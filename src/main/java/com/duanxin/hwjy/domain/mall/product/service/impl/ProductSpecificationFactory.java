package com.duanxin.hwjy.domain.mall.product.service.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductSpecificationDO;
import com.duanxin.hwjy.infrastructure.repository.po.ProductSpecificationPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

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
}
