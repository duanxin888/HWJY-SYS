package com.duanxin.hwjy.application.service.command;

import com.duanxin.hwjy.domain.mall.order.entity.OrderDO;
import com.duanxin.hwjy.domain.mall.order.repository.UserOrderRepository;
import com.duanxin.hwjy.domain.mall.order.service.CartDomainService;
import com.duanxin.hwjy.domain.mall.order.service.OrderDomainService;
import com.duanxin.hwjy.domain.user.event.Consumption4OrderEvent;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

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
    private final UserOrderRepository userOrderRepository;
    private final ApplicationContext applicationContext;

    @Transactional
    public void submitOrder(OrderDO orderDO) {
        cartDomainService.dealCarts4Order(orderDO.getUserId(), orderDO.getOrderDetails().getProductInfos());
        orderDomainService.submitOrder(orderDO);
    }

    public void cancelOrder() {
        orderDomainService.cancelOrder();
    }

    public void cancelOrder(String orderSn) {
        orderDomainService.cancelOrder(orderSn);
    }

    public void payOrder(String integralAccountSn, String orderSn) {
        OrderDO orderDO = userOrderRepository.selectByOrderSn(orderSn);
        // points consumption
        Consumption4OrderEvent event = assemblerEvent(integralAccountSn, orderDO.getTotalPrice(),
                orderDO.getOrderSn());
        applicationContext.publishEvent(event);
        // order status change & reduce product stock
        orderDomainService.pay4Order(orderDO);
    }

    private Consumption4OrderEvent assemblerEvent(String integralAccountSn,
                                                  BigDecimal totalPrice,
                                                  String orderSn) {
        Consumption4OrderEvent event = new Consumption4OrderEvent();
        event.setIntegralNumber(totalPrice);
        event.setIntegralAccountSn(integralAccountSn);
        event.setId(UUID.randomUUID().toString());
        event.setSource(orderSn);
        event.setData(JsonUtil.toString(event));
        return event;
    }

}
