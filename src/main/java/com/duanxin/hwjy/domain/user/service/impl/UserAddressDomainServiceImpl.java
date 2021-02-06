package com.duanxin.hwjy.domain.user.service.impl;

import com.duanxin.hwjy.domain.user.entity.UserAddressDO;
import com.duanxin.hwjy.domain.user.repository.UserAddressRepository;
import com.duanxin.hwjy.domain.user.service.UserAddressDomainService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressDomainServiceImpl
 * @date 2021/02/06 10:09
 */
@Service
@Slf4j
@AllArgsConstructor
public class UserAddressDomainServiceImpl implements UserAddressDomainService {

    private final UserAddressRepository userAddressRepository;

    @Override
    public void addAddress(UserAddressDO addressDO) {
        userAddressRepository.addAddress(addressDO);
    }
}
