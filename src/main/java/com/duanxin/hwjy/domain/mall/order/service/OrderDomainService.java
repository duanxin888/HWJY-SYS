package com.duanxin.hwjy.domain.mall.order.service;

import com.duanxin.hwjy.domain.mall.order.entity.OrderDO;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDomainService
 * @date 2021/04/13 10:11
 */
public interface OrderDomainService {
    void submitOrder(OrderDO orderDO);

    void cancelOrder();

    void cancelOrder(String orderSn);

    void pay4Order(OrderDO orderDO);
}
