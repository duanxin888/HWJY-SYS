package com.duanxin.hwjy.application.service.query;

import com.duanxin.hwjy.domain.user.entity.UserAddressDO;
import com.duanxin.hwjy.domain.user.repository.UserAddressRepository;
import com.duanxin.hwjy.domain.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className AddressQueryAppService
 * @date 2021/04/22 21:25
 */
@Service
@AllArgsConstructor
public class AddressQueryAppService {

    private final UserAddressRepository userAddressRepository;
    private final UserRepository userRepository;

    public UserAddressDO getAddressById(int addressId) {
        return userAddressRepository.selectById(addressId);
    }

    public UserAddressDO getDefaultAddress(int userId) {
        checkUser(userId);
        return userAddressRepository.selectDefaultAddress(userId);
    }

    private void checkUser(int userId) {
        userRepository.selectById(userId);
    }
}
