package com.duanxin.hwjy.application.service.query;

import com.duanxin.hwjy.domain.mall.order.entity.valueobject.OrderCounts;
import com.duanxin.hwjy.domain.mall.order.repository.UserOrderRepository;
import com.duanxin.hwjy.domain.user.repository.UserRepository;
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

    private void checkUser(int userId) {
        userRepository.selectById(userId);
    }
}
