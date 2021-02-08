package com.duanxin.hwjy.application.service.query;

import com.duanxin.hwjy.domain.user.entity.UserAddressDO;
import com.duanxin.hwjy.domain.user.entity.UserDO;
import com.duanxin.hwjy.domain.user.repository.UserAddressRepository;
import com.duanxin.hwjy.domain.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className UserQueryAppService
 * @date 2021/01/25 08:56
 */
@Service
@AllArgsConstructor
public class UserQueryAppService {

    private final UserRepository userRepository;
    private final UserAddressRepository userAddressRepository;

    public UserDO getUserInfo(int userId) {
        return userRepository.selectById(userId);
    }

    public UserDO queryAddress(int userId) {
        UserDO userDO = userRepository.selectById(userId);
        List<UserAddressDO> userAddressDOS = userAddressRepository.selectByUserId(userId);
        userDO.fillAddress(userAddressDOS);
        return userDO;
    }
}
