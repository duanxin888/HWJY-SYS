package com.duanxin.hwjy.domain.mall.product.service.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductDO;
import com.duanxin.hwjy.infrastructure.repository.po.ProductPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductFactory
 * @date 2021/04/02 09:08
 */
@Component
public class ProductFactory {

    public ProductPO do2PO(ProductDO productDO) {
        ProductPO po = new ProductPO();
        BeanUtils.copyProperties(productDO, po);
        po.setTransactionRule(JsonUtil.toString(productDO.getTransactionRule()));
        po.setOnSale(productDO.getOnSale().getCode());
        po.setDeleted(productDO.getDeleted().getCode());
        return po;
    }
}
