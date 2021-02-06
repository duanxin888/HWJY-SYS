package com.duanxin.hwjy.domain.user.repository.impl;

import com.duanxin.hwjy.domain.user.entity.UserDO;
import com.duanxin.hwjy.domain.user.entity.valueobject.UserStatus;
import com.duanxin.hwjy.domain.user.repository.IntegralAccountRepository;
import com.duanxin.hwjy.domain.user.repository.UserRepository;
import com.duanxin.hwjy.domain.user.service.impl.factory.UserFactory;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import com.duanxin.hwjy.infrastructure.repository.mapper.UserMapper;
import com.duanxin.hwjy.infrastructure.repository.po.IntegralAccountPO;
import com.duanxin.hwjy.infrastructure.repository.po.UserPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className UserRepositoryImpl
 * @date 2021/01/14 09:29
 */
@Repository
@AllArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository {

    private final UserMapper userMapper;
    private final IntegralAccountRepository integralAccountRepository;
    private final UserFactory userFactory;

    @Override
    public UserPO selectByOpenId(String openid) {
        UserPO userPO = userMapper.selectByOpenId(openid);
        if (Objects.isNull(userPO)) {
            return null;
        }
        if (!UserStatus.isAvailable(userPO.getStatus()) || !Deleted.isValid(userPO.getDeleted())) {
            log.warn("user [{}] is not available", JsonUtil.toString(userPO));
            throw new HWJYCheckException(ResultEnum.USER_IS_NOT_AVAILABLE);
        }
        return userPO;
    }

    @Override
    public UserPO insert(UserPO userPO) {
        userMapper.insert(userPO);
        log.info("success to insert user [{}]", JsonUtil.toString(userPO));
        return userPO;
    }

    @Override
    public void updateSessionKey(UserPO userPO) {
        userMapper.updateSessionKey(userPO.getId(), userPO.getWxSessionKey());
        log.info("success to update user [{}] sessionKey", JsonUtil.toString(userPO));
    }

    @Override
    public UserDO selectById(int userId) {
        UserPO userPO = userMapper.selectById(userId);
        if (Objects.isNull(userPO)) {
            throw new HWJYCheckException(ResultEnum.USER_IS_NOT_EXIST);
        }
        if (!UserStatus.isAvailable(userPO.getStatus()) || !Deleted.isValid(userPO.getDeleted())) {
            log.warn("user [{}] is not available", JsonUtil.toString(userPO));
            throw new HWJYCheckException(ResultEnum.USER_IS_NOT_AVAILABLE);
        }
        IntegralAccountPO integralAccountPO =
                integralAccountRepository.selectBySn(userPO.getIntegralAccountSn());
        return userFactory.createUserDO(userPO, userFactory.createIntegralAccountDO(integralAccountPO));
    }
}
