package com.duanxin.hwjy.domain.mall.order.service.impl;

import com.duanxin.hwjy.domain.mall.order.entity.UserCartDO;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.CartStatus;
import com.duanxin.hwjy.infrastructure.repository.po.UserCartPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author duanxin
 * @version 1.0
 * @className UserCartFactory
 * @date 2021/04/12 09:25
 */
@Component
public class UserCartFactory {

    public UserCartDO po2DO(UserCartPO po) {
        UserCartDO cartDO = new UserCartDO();
        BeanUtils.copyProperties(po, cartDO);
        cartDO.setCartStatus(CartStatus.formatByCode(po.getCartStatus()));
        return cartDO;
    }

    public UserCartPO do2PO(UserCartDO cartDO) {
        UserCartPO po = new UserCartPO();
        BeanUtils.copyProperties(cartDO, po);
        po.setCartStatus(cartDO.getCartStatus().getCode());
        return po;
    }
}
