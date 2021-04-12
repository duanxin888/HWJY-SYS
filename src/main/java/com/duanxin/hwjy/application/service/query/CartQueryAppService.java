package com.duanxin.hwjy.application.service.query;

import com.duanxin.hwjy.domain.mall.order.entity.UserCartDO;
import com.duanxin.hwjy.domain.mall.order.repository.UserCartRepository;
import com.duanxin.hwjy.domain.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className CartQueryAppService
 * @date 2021/04/12 16:01
 */
@Service
@AllArgsConstructor
public class CartQueryAppService {

    private final UserCartRepository userCartRepository;
    private final UserRepository userRepository;

    public UserCartDO getUserCart(int userId) {
        checkUser(userId);
        return userCartRepository.selectCartByUserId(userId);
    }

    private void checkUser(int userId) {
        userRepository.selectById(userId);
    }
}
