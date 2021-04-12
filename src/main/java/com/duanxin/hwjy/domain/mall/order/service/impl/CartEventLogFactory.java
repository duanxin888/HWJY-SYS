package com.duanxin.hwjy.domain.mall.order.service.impl;

import com.duanxin.hwjy.domain.mall.order.entity.CartEventLogDO;
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
}
