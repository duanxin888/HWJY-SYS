package com.duanxin.hwjy.domain.mall.order.repository;

import com.duanxin.hwjy.domain.mall.order.entity.OrderDO;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.OrderCounts;

/**
 * @author duanxin
 * @version 1.0
 * @className UserOrderRepository
 * @date 2021/04/13 10:09
 */
public interface UserOrderRepository {
    void submitOrder(OrderDO orderDO);

    OrderCounts selectOrderCounts(int userId);
}
