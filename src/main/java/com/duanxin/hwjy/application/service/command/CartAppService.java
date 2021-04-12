package com.duanxin.hwjy.application.service.command;

import com.duanxin.hwjy.domain.mall.order.entity.CartEventLogDO;
import com.duanxin.hwjy.domain.mall.order.service.CartDomainService;
import com.duanxin.hwjy.domain.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className CartAppService
 * @date 2021/04/11 10:51
 */
@Service
@AllArgsConstructor
public class CartAppService {

    private final UserRepository userRepository;
    private final CartDomainService cartDomainService;

    public void modifyCart(Integer userId, CartEventLogDO eventLogDO) {
        // check user exist
        checkUser(userId);
        // modify cart
        cartDomainService.modifyCart(userId, eventLogDO);
    }

    private void checkUser(Integer userId) {
        userRepository.selectById(userId);
    }
}
