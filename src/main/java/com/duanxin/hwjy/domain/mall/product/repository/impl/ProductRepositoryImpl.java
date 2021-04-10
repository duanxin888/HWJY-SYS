package com.duanxin.hwjy.domain.mall.product.repository.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductAttributeDO;
import com.duanxin.hwjy.domain.mall.product.entity.ProductDO;
import com.duanxin.hwjy.domain.mall.product.entity.ProductSpecificationDO;
import com.duanxin.hwjy.domain.mall.product.entity.ProductStockDO;
import com.duanxin.hwjy.domain.mall.product.entity.valueobject.OnSale;
import com.duanxin.hwjy.domain.mall.product.repository.ProductAttributeRepository;
import com.duanxin.hwjy.domain.mall.product.repository.ProductRepository;
import com.duanxin.hwjy.domain.mall.product.repository.ProductSpecificationRepository;
import com.duanxin.hwjy.domain.mall.product.repository.ProductStockRepository;
import com.duanxin.hwjy.domain.mall.product.service.impl.ProductFactory;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import com.duanxin.hwjy.infrastructure.repository.mapper.ProductMapper;
import com.duanxin.hwjy.infrastructure.repository.po.ProductPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductRepositoryImpl
 * @date 2021/04/02 09:06
 */
@Repository
@AllArgsConstructor
@Slf4j
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductMapper productMapper;
    private final ProductFactory productFactory;
    private final ProductAttributeRepository productAttributeRepository;
    private final ProductSpecificationRepository productSpecificationRepository;
    private final ProductStockRepository productStockRepository;

    @Override
    public int insert(ProductDO productDO) {
        ProductPO po = productFactory.do2PO(productDO);
        productMapper.insert(po);
        log.info("success to insert product [{}]", JsonUtil.toString(po));
        return po.getId();
    }

    @Override
    public ProductDO selectByName(String name) {
        ProductPO po = productMapper.selectByName(name);
        return Objects.isNull(po) ? null : productFactory.po2DO(po);
    }

    @Override
    public List<ProductDO> getProductsByCid(int cid, int pageNum, int pageSize) {
        List<ProductPO> pos = productMapper.selectProductsByCid(cid, (pageNum - 1) * pageSize, pageSize);
        return pos.stream().filter(f -> Deleted.isValid(f.getDeleted()) && OnSale.isOnSale(f.getOnSale())).
                map(productFactory::po2DO).collect(Collectors.toList());
    }

    @Override
    public ProductDO detailsProduct(int id) {
        ProductPO po = productMapper.selectById(id);
        ProductDO productDO = productFactory.po2DO(po);
        productDO.checkValidity();

        List<ProductAttributeDO> attributeDOS = productAttributeRepository.selectByPid(id);
        List<ProductSpecificationDO> specificationDOS = productSpecificationRepository.selectByPid(id);
        List<ProductStockDO> stockDOS = productStockRepository.selectByPid(id);
        productDO.fillDetails(attributeDOS, specificationDOS, stockDOS);
        return productDO;
    }
}
