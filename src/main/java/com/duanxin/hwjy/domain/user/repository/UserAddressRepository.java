package com.duanxin.hwjy.domain.user.repository;

import com.duanxin.hwjy.domain.user.entity.UserAddressDO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressRepository
 * @date 2021/02/06 10:12
 */
public interface UserAddressRepository {

    void addAddress(UserAddressDO addressDO);

    List<UserAddressDO> selectByUserId(int userId);

    void updateAcquiescence(UserAddressDO userAddressDO);

    void updateAddress(UserAddressDO userAddressDO);

    UserAddressDO selectById(int id);

    void updateWithDelete(UserAddressDO userAddressDO);

    UserAddressDO selectDefaultAddress(int userId);
}
