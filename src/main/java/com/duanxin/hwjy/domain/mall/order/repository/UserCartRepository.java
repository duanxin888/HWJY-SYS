package com.duanxin.hwjy.domain.mall.order.repository;

import com.duanxin.hwjy.domain.mall.order.entity.UserCartDO;

/**
 * @author duanxin
 * @version 1.0
 * @className UserCartRepository
 * @date 2021/04/11 10:49
 */
public interface UserCartRepository {

    UserCartDO selectValidCart(Integer userId);

    int insert(UserCartDO cartDO);

    UserCartDO selectCartByUserId(int userId);

    void updateStatus2Invalid(UserCartDO cartDO);
}
