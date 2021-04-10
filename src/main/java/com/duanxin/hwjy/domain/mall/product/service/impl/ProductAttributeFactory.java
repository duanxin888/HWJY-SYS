package com.duanxin.hwjy.domain.mall.product.service.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductAttributeDO;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import com.duanxin.hwjy.infrastructure.repository.po.ProductAttributePO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

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

    public ProductAttributeDO po2DO(ProductAttributePO po) {
        if (Objects.isNull(po)) {
            throw new HWJYCheckException(ResultEnum.PRODUCT_ATTRIBUTE_NOT_EXIST);
        }
        ProductAttributeDO attributeDO = new ProductAttributeDO();
        BeanUtils.copyProperties(po, attributeDO);
        attributeDO.setDeleted(Deleted.formatByCode(po.getDeleted()));
        return attributeDO;
    }
}
