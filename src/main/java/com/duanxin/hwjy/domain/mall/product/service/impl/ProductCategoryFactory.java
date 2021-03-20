package com.duanxin.hwjy.domain.mall.product.service.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductCategoryDO;
import com.duanxin.hwjy.domain.mall.product.entity.valueobject.CategoryLevel;
import com.duanxin.hwjy.infrastructure.repository.po.ProductCategoryPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductCategoryFactory
 * @date 2021/03/19 10:24
 */
@Component
public class ProductCategoryFactory {

    public ProductCategoryPO do2PO(ProductCategoryDO categoryDO) {
        ProductCategoryPO po = new ProductCategoryPO();
        BeanUtils.copyProperties(categoryDO, po);
        po.setLevel(categoryDO.getLevel().name());
        return po;
    }

    public ProductCategoryDO po2DO(ProductCategoryPO po) {
        ProductCategoryDO categoryDO = new ProductCategoryDO();
        BeanUtils.copyProperties(po, categoryDO);
        categoryDO.setLevel(CategoryLevel.formatByName(po.getName()));
        return categoryDO;
    }
}
