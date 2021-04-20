package com.duanxin.hwjy.domain.mall.order.repository.impl;

import com.duanxin.hwjy.domain.mall.order.entity.OrderDO;
import com.duanxin.hwjy.domain.mall.order.repository.UserOrderRepository;
import com.duanxin.hwjy.domain.mall.order.service.impl.UserOrderFactory;
import com.duanxin.hwjy.infrastructure.repository.mapper.UserOrderMapper;
import com.duanxin.hwjy.infrastructure.repository.po.UserOrderPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

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
}
