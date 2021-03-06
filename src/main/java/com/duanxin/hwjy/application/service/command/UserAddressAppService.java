package com.duanxin.hwjy.application.service.command;

import com.duanxin.hwjy.domain.user.entity.UserAddressDO;
import com.duanxin.hwjy.domain.user.service.UserAddressDomainService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressAppService
 * @date 2021/02/06 10:05
 */
@Service
@AllArgsConstructor
@Slf4j
public class UserAddressAppService {

    private final UserAddressDomainService userAddressDomainService;

    public void addAddress(UserAddressDO addressDO) {
        userAddressDomainService.addAddress(addressDO);
    }

    public void updateAcquiescence(List<UserAddressDO> dos) {
        userAddressDomainService.updateAcquiescence(dos);
    }

    public void updateAddress(UserAddressDO userAddressDO) {
        userAddressDomainService.updateAddress(userAddressDO);
    }

    public void deleteAddress(int addressId) {
        userAddressDomainService.deleteAddress(addressId);
    }
}
