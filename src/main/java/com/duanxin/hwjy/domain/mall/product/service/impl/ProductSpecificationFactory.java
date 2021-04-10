package com.duanxin.hwjy.domain.mall.product.service.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductSpecificationDO;
import com.duanxin.hwjy.domain.mall.product.entity.valueobject.ProductGallery;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import com.duanxin.hwjy.infrastructure.repository.po.ProductSpecificationPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductSpecificationFactory
 * @date 2021/04/02 09:23
 */
@Component
public class ProductSpecificationFactory {

    public ProductSpecificationPO do2PO(ProductSpecificationDO specificationDO) {
        ProductSpecificationPO po = new ProductSpecificationPO();
        BeanUtils.copyProperties(specificationDO, po);
        po.setDeleted(specificationDO.getDeleted().getCode());
        po.setGallery(JsonUtil.toString(specificationDO.getGallery()));
        return po;
    }

    public ProductSpecificationDO po2DO(ProductSpecificationPO po) {
        if (Objects.isNull(po)) {
            throw new HWJYCheckException(ResultEnum.PRODUCT_SPECIFICATION_NOT_EXIST);
        }
        ProductSpecificationDO specificationDO = new ProductSpecificationDO();
        BeanUtils.copyProperties(po, specificationDO);
        specificationDO.setDeleted(Deleted.formatByCode(po.getDeleted()));
        specificationDO.setGallery(JsonUtil.toObjectList(po.getGallery(), ProductGallery.class).
                orElse(Collections.emptyList()));
        return specificationDO;
    }
}
