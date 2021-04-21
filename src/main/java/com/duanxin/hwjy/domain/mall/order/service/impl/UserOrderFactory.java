package com.duanxin.hwjy.domain.mall.order.service.impl;

import com.duanxin.hwjy.domain.mall.order.entity.OrderDO;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.OrderCounts;
import com.duanxin.hwjy.infrastructure.repository.OrderCountsDto;
import com.duanxin.hwjy.infrastructure.repository.po.UserOrderPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author duanxin
 * @version 1.0
 * @className UserOrderFactory
 * @date 2021/04/20 11:17
 */
@Component
public class UserOrderFactory {

    public UserOrderPO do2PO(OrderDO orderDO) {
        UserOrderPO po = new UserOrderPO();
        BeanUtils.copyProperties(orderDO, po);
        po.setOrderStatus(orderDO.getOrderStatus().name());
        po.setAddressInfo(JsonUtil.toString(orderDO.getAddressInfo()));
        po.setPayInfo(JsonUtil.toString(orderDO.getPayInfo()));
        po.setShipInfo(JsonUtil.toString(orderDO.getShipInfo()));
        po.setOrderDetails(JsonUtil.toString(orderDO.getOrderDetails()));
        return po;
    }

    public OrderCounts dto2Counts(OrderCountsDto dto) {
        OrderCounts orderCounts = new OrderCounts();
        BeanUtils.copyProperties(dto, orderCounts);
        return orderCounts;
    }
}
