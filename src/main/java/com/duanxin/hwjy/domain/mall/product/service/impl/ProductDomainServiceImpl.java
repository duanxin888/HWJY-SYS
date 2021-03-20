package com.duanxin.hwjy.domain.mall.product.service.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductCategoryDO;
import com.duanxin.hwjy.domain.mall.product.repository.ProductCategoryRepository;
import com.duanxin.hwjy.domain.mall.product.service.ProductDomainService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Override
    public void addProductCategory(ProductCategoryDO categoryDO) {
        productCategoryRepository.addProductCategory(categoryDO);
    }
}
