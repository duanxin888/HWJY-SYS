package com.duanxin.hwjy.application.service.query;

import com.duanxin.hwjy.domain.mall.order.entity.OrderDO;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.OrderCounts;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.OrderStatus;
import com.duanxin.hwjy.domain.mall.order.repository.UserOrderRepository;
import com.duanxin.hwjy.domain.user.repository.UserRepository;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderQueryAppService
 * @date 2021/04/21 09:10
 */
@Service
@AllArgsConstructor
public class OrderQueryAppService {

    private final UserOrderRepository userOrderRepository;
    private final UserRepository userRepository;

    public OrderCounts orderCounts(int userId) {
        // check user exist
        checkUser(userId);
        // fetch order counts
        return userOrderRepository.selectOrderCounts(userId);
    }

    public PageInfo<OrderDO> listOrder(Integer userId, OrderStatus orderStatus,
                                       Integer pageNum, Integer pageSize) {
        // check user exist
        checkUser(userId);
        // fetch order list by userId
        return userOrderRepository.listOrder(userId, orderStatus, pageNum, pageSize);
    }

    private void checkUser(int userId) {
        userRepository.selectById(userId);
    }
}
