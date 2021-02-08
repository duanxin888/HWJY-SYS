package com.duanxin.hwjy.domain.user.service.impl;

import com.duanxin.hwjy.domain.user.entity.UserAddressDO;
import com.duanxin.hwjy.domain.user.repository.UserAddressRepository;
import com.duanxin.hwjy.domain.user.service.UserAddressDomainService;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
        List<UserAddressDO> userAddressDOS = userAddressRepository.selectByUserId(addressDO.getUserId());
        if (CollectionUtils.isEmpty(userAddressDOS)) {
            addressDO.acquiesceIn();
            log.info("user first add address, then acquiesceIn address [{}]", JsonUtil.toString(addressDO));
        }
        userAddressRepository.addAddress(addressDO);
    }

    @Override
    public void updateAcquiescence(List<UserAddressDO> dos) {
        if (dos.size() != 2) {
            throw new HWJYCheckException(ResultEnum.USER_ADDRESS_UPDATE_ACQUIESCENCE_FAILED);
        }
        dos.forEach(userAddressRepository::updateAcquiescence);
    }

    @Override
    public void updateAddress(UserAddressDO userAddressDO) {
        userAddressDO.updateAddress();
        userAddressRepository.updateAddress(userAddressDO);
    }
}
