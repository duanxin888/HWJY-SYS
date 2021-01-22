package com.duanxin.hwjy.domain.user.service.impl;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.duanxin.hwjy.domain.user.entity.IntegralAccountDO;
import com.duanxin.hwjy.domain.user.entity.UserDO;
import com.duanxin.hwjy.domain.user.repository.IntegralAccountRepository;
import com.duanxin.hwjy.domain.user.repository.UserRepository;
import com.duanxin.hwjy.domain.user.service.UserDomainService;
import com.duanxin.hwjy.infrastructure.client.sn.SnGenerateManagerService;
import com.duanxin.hwjy.infrastructure.client.token.JwtClient;
import com.duanxin.hwjy.infrastructure.client.wx.WxClient;
import com.duanxin.hwjy.infrastructure.common.constants.JwtConstants;
import com.duanxin.hwjy.infrastructure.common.enums.SnType;
import com.duanxin.hwjy.infrastructure.repository.po.IntegralAccountPO;
import com.duanxin.hwjy.infrastructure.repository.po.UserPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
    private final JwtClient jwtClient;

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

        // create third session (with jwt, storage userInfo)
        String token = fetchJwtToken(userDO);
        userDO.create3SessionWithJwt(token);
        return userDO;
    }

    private String fetchJwtToken(UserDO userDO) {
        // assembler claims
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtConstants.USERNAME, userDO.getNickname());
        claims.put(JwtConstants.USERID, userDO.getId());
        claims.put(JwtConstants.CREATED, new Date());
        return jwtClient.generateToken(claims);
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
