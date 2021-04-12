package com.duanxin.hwjy.domain.mall.order.service.impl;

import com.duanxin.hwjy.domain.mall.order.entity.CartEventLogDO;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.CartOperateType;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.ProductInfo;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import com.duanxin.hwjy.infrastructure.repository.po.CartEventLogPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author duanxin
 * @version 1.0
 * @className CartEventLogFactory
 * @date 2021/04/12 09:52
 */
@Component
public class CartEventLogFactory {

    public CartEventLogPO do2PO(CartEventLogDO logDO) {
        CartEventLogPO po = new CartEventLogPO();
        BeanUtils.copyProperties(logDO, po);
        po.setOperateType(logDO.getOperateType().getCode());
        po.setProductInfo(JsonUtil.toString(logDO.getProductInfo()));
        return po;
    }

    public CartEventLogDO po2DO(CartEventLogPO po) {
        CartEventLogDO logDO = new CartEventLogDO();
        BeanUtils.copyProperties(po, logDO);
        logDO.setProductInfo(JsonUtil.toObject(po.getProductInfo(), ProductInfo.class).
                orElseThrow(() -> new HWJYCheckException(ResultEnum.USER_CART_PRODUCT_TRANS_ERROR)));
        logDO.setOperateType(CartOperateType.formatByCode(po.getOperateType()));
        return logDO;
    }
}
