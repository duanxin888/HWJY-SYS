package com.duanxin.hwjy.domain.user.repository.impl;

import com.duanxin.hwjy.domain.user.entity.UserAddressDO;
import com.duanxin.hwjy.domain.user.repository.UserAddressRepository;
import com.duanxin.hwjy.domain.user.service.impl.factory.UserAddressFactory;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import com.duanxin.hwjy.infrastructure.repository.mapper.UserAddressMapper;
import com.duanxin.hwjy.infrastructure.repository.po.UserAddressPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressRepositoryImpl
 * @date 2021/02/06 10:13
 */
@Repository
@Slf4j
@AllArgsConstructor
public class UserAddressRepositoryImpl implements UserAddressRepository {

    private final UserAddressMapper userAddressMapper;
    private final UserAddressFactory userAddressFactory;

    @Override
    public void addAddress(UserAddressDO addressDO) {
        UserAddressPO po = userAddressFactory.createUserAddressPO(addressDO);
        userAddressMapper.insert(po);
        log.info("success to insert userAddress [{}]", JsonUtil.toString(po));
    }

    @Override
    public List<UserAddressDO> selectByUserId(int userId) {
        return userAddressMapper.selectByUserId(userId).stream().
                filter(u -> Deleted.isValid(u.getDeleted())).
                map(userAddressFactory::createUserAddressDO).
                collect(Collectors.toList());
    }
}
