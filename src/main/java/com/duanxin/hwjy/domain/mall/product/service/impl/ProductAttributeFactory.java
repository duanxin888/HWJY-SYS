package com.duanxin.hwjy.domain.mall.product.service.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductAttributeDO;
import com.duanxin.hwjy.infrastructure.repository.po.ProductAttributePO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductAttributeFactory
 * @date 2021/04/02 09:28
 */
@Component
public class ProductAttributeFactory {

    public ProductAttributePO do2PO(ProductAttributeDO attributeDO) {
        ProductAttributePO po = new ProductAttributePO();
        BeanUtils.copyProperties(attributeDO, po);
        po.setDeleted(attributeDO.getDeleted().getCode());
        return po;
    }
}
