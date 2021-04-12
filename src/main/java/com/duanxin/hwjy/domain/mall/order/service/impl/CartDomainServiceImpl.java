package com.duanxin.hwjy.domain.mall.order.service.impl;

import com.duanxin.hwjy.domain.mall.order.entity.CartEventLogDO;
import com.duanxin.hwjy.domain.mall.order.entity.UserCartDO;
import com.duanxin.hwjy.domain.mall.order.repository.CartEventLogRepository;
import com.duanxin.hwjy.domain.mall.order.repository.UserCartRepository;
import com.duanxin.hwjy.domain.mall.order.service.CartDomainService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className CartDomainServiceImpl
 * @date 2021/04/11 10:50
 */
@Service
@AllArgsConstructor
@Slf4j
public class CartDomainServiceImpl implements CartDomainService {

    private final UserCartRepository userCartRepository;
    private final CartEventLogRepository cartEventLogRepository;

    @Override
    @Transactional
    public void modifyCart(Integer userId, CartEventLogDO eventLogDO) {
        // fetch user valid cart
        // if valid cart not exist --> create valid cart
        int validCartId = fetchUserValidCart(userId);
        // append cart event log
        appendLog(validCartId, eventLogDO);
    }

    private void appendLog(int cartId, CartEventLogDO eventLogDO) {
        eventLogDO.create(cartId);
        cartEventLogRepository.appendLog(eventLogDO);
    }

    private int fetchUserValidCart(Integer userId) {
        UserCartDO cartDO = userCartRepository.selectValidCart(userId);
        if (Objects.isNull(cartDO)) {
            log.info("user [{}] valid cart not exist", userId);
            cartDO = new UserCartDO(userId);
            return userCartRepository.insert(cartDO);
        }
        return cartDO.getId();
    }
}
