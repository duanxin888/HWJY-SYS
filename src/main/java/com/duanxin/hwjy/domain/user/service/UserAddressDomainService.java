package com.duanxin.hwjy.domain.user.service;

import com.duanxin.hwjy.domain.user.entity.UserAddressDO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressDomainService
 * @date 2021/02/06 10:08
 */
public interface UserAddressDomainService {
    void addAddress(UserAddressDO addressDO);

    void updateAcquiescence(List<UserAddressDO> dos);
}
