package com.duanxin.hwjy.domain.mall.order.repository.impl;

import com.duanxin.hwjy.domain.mall.order.entity.OrderDO;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.OrderCounts;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.OrderStatus;
import com.duanxin.hwjy.domain.mall.order.repository.UserOrderRepository;
import com.duanxin.hwjy.domain.mall.order.service.impl.UserOrderFactory;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import com.duanxin.hwjy.infrastructure.repository.OrderCountsDto;
import com.duanxin.hwjy.infrastructure.repository.mapper.UserOrderMapper;
import com.duanxin.hwjy.infrastructure.repository.po.UserOrderPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className UserOrderRepositoryImpl
 * @date 2021/04/13 10:10
 */
@Repository
@AllArgsConstructor
@Slf4j
public class UserOrderRepositoryImpl implements UserOrderRepository {

    private final UserOrderMapper userOrderMapper;
    private final UserOrderFactory userOrderFactory;

    @Override
    public void submitOrder(OrderDO orderDO) {
        UserOrderPO po = userOrderFactory.do2PO(orderDO);
        userOrderMapper.insert(po);
        log.info("success to insert order [{}]", JsonUtil.toString(po));
    }

    @Override
    public OrderCounts selectOrderCounts(int userId) {
        OrderCountsDto dto = userOrderMapper.selectOrderCounts(userId);
        return userOrderFactory.dto2Counts(dto);
    }

    @Override
    public PageInfo<OrderDO> listOrder(Integer userId, OrderStatus orderStatus,
                                       Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        if (OrderStatus.ALL.equals(orderStatus)) {
            // fetch all orders
            return new PageInfo<>(userOrderMapper.selectAll(userId).stream().
                    map(userOrderFactory::po2DO).filter(f -> OrderStatus.checkValid(f.getOrderStatus())).
                    collect(Collectors.toList()));
        }
        return new PageInfo<>(userOrderMapper.selectByStatus(userId, orderStatus.name()).
                stream().map(userOrderFactory::po2DO).filter(f -> OrderStatus.checkValid(f.getOrderStatus())).
                collect(Collectors.toList()));
    }

    @Override
    public List<OrderDO> selectOvertimeUnpaidOrders(LocalDateTime limitTime) {
        return userOrderMapper.selectOvertimeUnpaid(limitTime).stream().
                map(userOrderFactory::po2DO).filter(f -> OrderStatus.checkValid(f.getOrderStatus())).
                collect(Collectors.toList());
    }

    @Override
    public void updateWithCancelOrder(OrderDO orderDO) {
        userOrderMapper.updateWithCancelOrder(orderDO.getId(), orderDO.getOrderStatus().name(),
                orderDO.getOrderCloseTime(), orderDO.getEdate());
        log.info("success to cancel order [{}]", orderDO.getOrderSn());
    }

    @Override
    public OrderDO selectByOrderSn(String orderSn) {
        OrderDO orderDO = userOrderFactory.po2DO(userOrderMapper.selectByOrderSn(orderSn));
        if (!OrderStatus.checkValid(orderDO.getOrderStatus())) {
            throw new HWJYCheckException(ResultEnum.USER_ORDER_IS_DELETED);
        }
        return orderDO;
    }

    @Override
    public void updateWithPayOrder(OrderDO orderDO) {
        userOrderMapper.updateWithPayOrder(orderDO.getId(), orderDO.getOrderStatus().name(),
                JsonUtil.toString(orderDO.getPayInfo()), orderDO.getEdate());
        log.info("success to pay order [{}]", JsonUtil.toString(orderDO));
    }

    @Override
    public void updateWithDeletedOrder(OrderDO orderDO) {
        userOrderMapper.updateWithDeletedOrder(orderDO.getId(), orderDO.getOrderStatus().name(),
                orderDO.getEdate());
        log.info("success to deleted order [{}]", JsonUtil.toString(orderDO));
    }
}
