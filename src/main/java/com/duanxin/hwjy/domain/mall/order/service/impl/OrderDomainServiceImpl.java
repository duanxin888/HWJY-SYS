package com.duanxin.hwjy.domain.mall.order.service.impl;

import com.duanxin.hwjy.domain.mall.order.entity.OrderDO;
import com.duanxin.hwjy.domain.mall.order.repository.UserOrderRepository;
import com.duanxin.hwjy.domain.mall.order.service.OrderDomainService;
import com.duanxin.hwjy.infrastructure.client.sn.OrderSnGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDomainServiceImpl
 * @date 2021/04/13 10:11
 */
@Service
@AllArgsConstructor
@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService {

    private final UserOrderRepository userOrderRepository;
    private final OrderSnGenerator orderSnGenerator;

    @Override
    public void submitOrder(OrderDO orderDO) {
        // init order
        orderDO.init(orderSnGenerator.generate());
        // insert order
        userOrderRepository.submitOrder(orderDO);
    }
}
