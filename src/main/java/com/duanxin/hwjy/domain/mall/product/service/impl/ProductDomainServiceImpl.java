package com.duanxin.hwjy.domain.mall.product.service.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductCategoryDO;
import com.duanxin.hwjy.domain.mall.product.entity.ProductDO;
import com.duanxin.hwjy.domain.mall.product.repository.ProductAttributeRepository;
import com.duanxin.hwjy.domain.mall.product.repository.ProductCategoryRepository;
import com.duanxin.hwjy.domain.mall.product.repository.ProductRepository;
import com.duanxin.hwjy.domain.mall.product.repository.ProductSpecificationRepository;
import com.duanxin.hwjy.domain.mall.product.service.ProductDomainService;
import com.duanxin.hwjy.infrastructure.client.sn.SnGenerateManagerService;
import com.duanxin.hwjy.infrastructure.common.enums.SnType;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductDomainServiceImpl
 * @date 2021/03/19 09:26
 */
@Service
@AllArgsConstructor
@Slf4j
public class ProductDomainServiceImpl implements ProductDomainService {

    private final ProductCategoryRepository productCategoryRepository;
    private final SnGenerateManagerService snGenerateManagerService;
    private final ProductRepository productRepository;
    private final ProductSpecificationRepository productSpecificationRepository;
    private final ProductAttributeRepository productAttributeRepository;

    @Override
    public void addProductCategory(ProductCategoryDO categoryDO) {
        // valid duplicate category
        if (Objects.nonNull(productCategoryRepository.selectByName(categoryDO.getName()))) {
            log.info("product category [{}] is exist", categoryDO.getName());
            throw new HWJYCheckException(ResultEnum.PRODUCT_CATEGORY_IS_EXIST);
        }
        productCategoryRepository.addProductCategory(categoryDO);
    }

    @Override
    @Transactional
    public void addProduct(ProductDO productDO) {
        // valid duplicate product
        if (Objects.nonNull(productRepository.selectByName(productDO.getName()))) {
            log.info("product [{}] is exist", productDO.getName());
            throw new HWJYCheckException(ResultEnum.PRODUCT_IS_EXIST_BY_NAME);
        }
        // insert product
        productDO.fillSn(snGenerateManagerService.generate(SnType.PRODUCT_SN_TYPE));
        int productId = productRepository.insert(productDO);
        // insert specification & attribute
        productDO.getProductSpecifications().forEach(specification -> {
            specification.fillProductId(productId);
            productSpecificationRepository.insert(specification);
        });
        productDO.getProductAttributes().forEach(attribute -> {
            attribute.fillProductId(productId);
            productAttributeRepository.insert(attribute);
        });
    }
}
