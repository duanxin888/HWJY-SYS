package com.duanxin.hwjy.application.service.command;

import com.duanxin.hwjy.domain.mall.order.entity.OrderDO;
import com.duanxin.hwjy.domain.mall.order.service.CartDomainService;
import com.duanxin.hwjy.domain.mall.order.service.OrderDomainService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderAppService
 * @date 2021/04/13 10:11
 */
@Service
@AllArgsConstructor
public class OrderAppService {

    private final OrderDomainService orderDomainService;
    private final CartDomainService cartDomainService;

    @Transactional
    public void submitOrder(OrderDO orderDO) {
        cartDomainService.dealCarts4Order(orderDO.getUserId(), orderDO.getOrderDetails().getProductInfos());
        orderDomainService.submitOrder(orderDO);
    }

    public void cancelOrder() {
        orderDomainService.cancelOrder();
    }
}
