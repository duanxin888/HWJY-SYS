package com.duanxin.hwjy.domain.mall.order.repository.impl;

import com.duanxin.hwjy.domain.mall.order.entity.UserCartDO;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.CartStatus;
import com.duanxin.hwjy.domain.mall.order.repository.UserCartRepository;
import com.duanxin.hwjy.domain.mall.order.service.impl.UserCartFactory;
import com.duanxin.hwjy.infrastructure.repository.mapper.UserCartMapper;
import com.duanxin.hwjy.infrastructure.repository.po.UserCartPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className UserCartRepositoryImpl
 * @date 2021/04/11 10:49
 */
@Repository
@AllArgsConstructor
@Slf4j
public class UserCartRepositoryImpl implements UserCartRepository {

    private final UserCartMapper userCartMapper;
    private final UserCartFactory userCartFactory;

    @Override
    public UserCartDO selectValidCart(Integer userId) {
        UserCartPO po =
                userCartMapper.selectValidCart(userId, CartStatus.VALID.getCode());
        return Objects.isNull(po) ? null : userCartFactory.po2DO(po);
    }

    @Override
    public int insert(UserCartDO cartDO) {
        UserCartPO po = userCartFactory.do2PO(cartDO);
        userCartMapper.insert(po);
        log.info("success to insert UserCart [{}]", JsonUtil.toString(po));
        return po.getId();
    }
}
