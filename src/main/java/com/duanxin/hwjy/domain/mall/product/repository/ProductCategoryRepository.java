package com.duanxin.hwjy.domain.mall.product.repository;

import com.duanxin.hwjy.domain.mall.product.entity.ProductCategoryDO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductCategoryRepository
 * @date 2021/03/19 09:24
 */
public interface ProductCategoryRepository {
    void addProductCategory(ProductCategoryDO categoryDO);

    List<ProductCategoryDO> getCategories();
}
