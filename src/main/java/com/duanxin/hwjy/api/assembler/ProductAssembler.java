package com.duanxin.hwjy.api.assembler;

import com.duanxin.hwjy.api.dto.product.ProductAddCommandDto;
import com.duanxin.hwjy.api.dto.product.ProductsQueryResponseDto;
import com.duanxin.hwjy.domain.mall.product.entity.ProductAttributeDO;
import com.duanxin.hwjy.domain.mall.product.entity.ProductDO;
import com.duanxin.hwjy.domain.mall.product.entity.ProductSpecificationDO;
import com.duanxin.hwjy.domain.mall.product.entity.valueobject.OnSale;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

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

    public static ProductsQueryResponseDto do2ProductsQueryResponseDto(ProductDO productDO) {
        ProductsQueryResponseDto dto = new ProductsQueryResponseDto();
        BeanUtils.copyProperties(productDO, dto);
        return dto;
    }
}
