package com.duanxin.hwjy.api.assembler;

import com.duanxin.hwjy.api.dto.product.*;
import com.duanxin.hwjy.domain.mall.product.entity.ProductAttributeDO;
import com.duanxin.hwjy.domain.mall.product.entity.ProductDO;
import com.duanxin.hwjy.domain.mall.product.entity.ProductSpecificationDO;
import com.duanxin.hwjy.domain.mall.product.entity.valueobject.OnSale;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductAssembler
 * @date 2021/04/01 20:26
 */
public class ProductAssembler {

    private ProductAssembler() {
    }

    public static ProductDO addCommand2DO(ProductAddCommandDto dto) {
        ProductDO productDO = new ProductDO();
        BeanUtils.copyProperties(dto, productDO);

        // assembler specifications
        List<ProductSpecificationDO> specificationDOS = new ArrayList<>(dto.getProductSpecifications().size());
        dto.getProductSpecifications().forEach(specification -> {
            ProductSpecificationDO specificationDO = new ProductSpecificationDO();
            BeanUtils.copyProperties(specification, specificationDO);
            specificationDOS.add(specificationDO);
        });
        productDO.setProductSpecifications(specificationDOS);
        // assembler attributes
        List<ProductAttributeDO> attributeDOS = new ArrayList<>(dto.getProductAttributes().size());
        dto.getProductAttributes().forEach(attribute -> {
            ProductAttributeDO attributeDO = new ProductAttributeDO();
            BeanUtils.copyProperties(attribute, attributeDO);
            attributeDOS.add(attributeDO);
        });
        productDO.setProductAttributes(attributeDOS);
        productDO.setOnSale(OnSale.formatByCode(dto.getOnSale()));
        return productDO;
    }

    public static ProductsPageResponseDto do2PageResponseDto(PageInfo<ProductDO> pageInfo) {
        ProductsPageResponseDto dto = new ProductsPageResponseDto();
        dto.setPageNum(pageInfo.getPageNum());
        dto.setPageSize(pageInfo.getPageSize());
        dto.setPages(pageInfo.getPages());
        dto.setProductsQueryDtos(pageInfo.getList().stream().
                map(ProductAssembler::do2ProductsQueryDto).collect(Collectors.toList()));
        return dto;
    }

    public static ProductsQueryDto do2ProductsQueryDto(ProductDO productDO) {
        ProductsQueryDto dto = new ProductsQueryDto();
        BeanUtils.copyProperties(productDO, dto);
        return dto;
    }

    public static ProductQueryResponseDto do2ProductQueryResponseDto(ProductDO productDO) {
        ProductQueryResponseDto dto = new ProductQueryResponseDto();
        BeanUtils.copyProperties(productDO, dto);

        // assembler attribute dto
        List<ProductAttributeDto> attributeDtos = new ArrayList<>(productDO.getProductAttributes().size());
        productDO.getProductAttributes().forEach(f -> {
            ProductAttributeDto attributeDto = new ProductAttributeDto();
            BeanUtils.copyProperties(f, attributeDto);
            attributeDtos.add(attributeDto);
        });
        dto.setAttributeDtos(attributeDtos);

        // assembler specification dto
        List<ProductSpecificationDto> specificationDtos = new ArrayList<>(productDO.getProductSpecifications().size());
        productDO.getProductSpecifications().forEach(f -> {
            ProductSpecificationDto specificationDto = new ProductSpecificationDto();
            BeanUtils.copyProperties(f, specificationDto);
            specificationDtos.add(specificationDto);
        });
        dto.setSpecificationDtos(specificationDtos);

        // assembler stock dto
        List<ProductStockDto> stockDtos = new ArrayList<>(productDO.getProductStocks().size());
        productDO.getProductStocks().forEach(f -> {
            ProductStockDto stockDto = new ProductStockDto();
            BeanUtils.copyProperties(f, stockDto);
            stockDtos.add(stockDto);
        });
        dto.setStockDtos(stockDtos);
        return dto;
    }
}
