package com.duanxin.hwjy.domain.mall.product.service;

import com.duanxin.hwjy.domain.mall.product.entity.ProductCategoryDO;
import com.duanxin.hwjy.domain.mall.product.entity.ProductDO;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductDomainService
 * @date 2021/03/19 09:26
 */
public interface ProductDomainService {
    void addProductCategory(ProductCategoryDO categoryDO);

    void addProduct(ProductDO productDO);
}
