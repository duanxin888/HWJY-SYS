package com.duanxin.hwjy.domain.user.service.impl;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.duanxin.hwjy.domain.user.entity.IntegralAccountDO;
import com.duanxin.hwjy.domain.user.entity.UserDO;
import com.duanxin.hwjy.domain.user.repository.IntegralAccountRepository;
import com.duanxin.hwjy.domain.user.repository.UserRepository;
import com.duanxin.hwjy.domain.user.service.UserDomainService;
import com.duanxin.hwjy.infrastructure.client.cache.CacheClient;
import com.duanxin.hwjy.infrastructure.client.sn.SnGenerateManagerService;
import com.duanxin.hwjy.infrastructure.client.wx.WxClient;
import com.duanxin.hwjy.infrastructure.common.enums.SnType;
import com.duanxin.hwjy.infrastructure.repository.po.IntegralAccountPO;
import com.duanxin.hwjy.infrastructure.repository.po.UserPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className UserDomainServiceImpl
 * @date 2021/01/14 08:56
 */
@Service
@Slf4j
@AllArgsConstructor
public class UserDomainServiceImpl implements UserDomainService {

    private final WxClient wxClient;
    private final UserRepository userRepository;
    private final UserFactory userFactory;
    private final SnGenerateManagerService snGenerateManagerService;
    private final IntegralAccountRepository integralAccountRepository;
    private final CacheClient cacheClient;

    @Override
    public UserDO login(UserDO userDO, String code, String appid) {
        log.info("user [{}] begin to login with wx code [{}]", JsonUtil.toString(userDO), code);
        WxMaJscode2SessionResult sessionResult = wxClient.getSession(appid, code);

        // check user if exist
        UserPO userPO = userRepository.selectByOpenId(sessionResult.getOpenid());
        if (Objects.isNull(userPO)) {
            // create user and integral account
            userPO = createUser(userDO, sessionResult);
        } else {
            // update user session key
            userPO.setWxSessionKey(sessionResult.getSessionKey());
            userRepository.updateSessionKey(userPO);
        }
        userDO = userFactory.createUserDO(userPO,
                userFactory.createIntegralAccountDO(integralAccountRepository.selectBySn(userPO.getIntegralAccountSn())));

        // create third session
        userDO.create3SessionWithUUID();
        // cache session
        cache4Session(userDO);
        return userDO;
    }

    /**
     * cache third session
     * key: userID:thirdSession
     * value: wxOpenid with sha256Hex({@link DigestUtils})
     * @param userDO user domain object
     * @date 2021/1/21 10:29
     * @return void
     */
    private void cache4Session(UserDO userDO) {
        String value = DigestUtils.sha256Hex(userDO.getWxOpenid());
        cacheClient.refreshCache(String.valueOf(userDO.getId()), value, Duration.ofDays(30), userDO.getThirdSession());
    }

    private UserPO createUser(UserDO userDO, WxMaJscode2SessionResult sessionResult) {
        // create user integral account
        String integralAccountSn = snGenerateManagerService.generate(SnType.INTEGRAL_ACCOUNT_SN_TYPE);
        IntegralAccountDO integralAccountDO =
                new IntegralAccountDO(integralAccountSn);
        IntegralAccountPO integralAccountPO =
                integralAccountRepository.insert(userFactory.createIntegralAccountPO(integralAccountDO));
        integralAccountDO.fillId(integralAccountPO.getId());

        // create user
        UserDO user = new UserDO();
        user.create(userDO.getUserImgUrl(), userDO.getNickname(), sessionResult.getOpenid(),
                sessionResult.getSessionKey(), integralAccountDO);
        return userRepository.insert(userFactory.createUserPO(user));
    }
}
