package com.duanxin.hwjy.domain.mall.order.service.impl;

import com.duanxin.hwjy.domain.mall.order.entity.OrderDO;
import com.duanxin.hwjy.domain.mall.order.repository.UserOrderRepository;
import com.duanxin.hwjy.domain.mall.order.service.OrderDomainService;
import com.duanxin.hwjy.infrastructure.client.sn.OrderSnGenerator;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

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
    @Qualifier("cancelOrderThreadPoolExecutor")
    private final ThreadPoolExecutor cancelOrderExecutor;

    @Override
    public void submitOrder(OrderDO orderDO) {
        // init order
        orderDO.init(orderSnGenerator.generate());
        // insert order
        userOrderRepository.submitOrder(orderDO);
    }

    @Override
    public void cancelOrder() {
        long start = System.currentTimeMillis();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime limitTime = now.minusMinutes(30);
        // fetch overtime unpaid orders
        List<OrderDO> overtimeUnpaidOrders = userOrderRepository.selectOvertimeUnpaidOrders(limitTime);
        // asyn execute cancel order
        // todo: unable to perform task
        List<Future<Boolean>> futures = overtimeUnpaidOrders.stream().
                map(orderDO -> cancelOrderExecutor.submit(() -> doCancelOrder(orderDO))).collect(Collectors.toList());
        for (Future<Boolean> future : futures) {
            while (!future.isDone()) ;
        }
        log.info("spend [{}]s to complete cancelOrder tasks [{}]",
                (System.currentTimeMillis() - start) / 1000, overtimeUnpaidOrders.size());
    }

    private boolean doCancelOrder(OrderDO orderDO) {
        try {
            orderDO.cancel();
            userOrderRepository.updateWithCancelOrder(orderDO);
        } catch (Throwable ex) {
            log.warn("failed to execute cancel order [{}] exception",
                    JsonUtil.toString(orderDO), ex);
        }
        return true;
    }
}
