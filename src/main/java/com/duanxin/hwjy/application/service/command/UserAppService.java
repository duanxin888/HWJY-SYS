package com.duanxin.hwjy.application.service.command;

import com.duanxin.hwjy.domain.user.entity.UserDO;
import com.duanxin.hwjy.domain.user.service.UserDomainService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAppService
 * @date 2021/01/10 08:19
 */
@Service
@AllArgsConstructor
@Slf4j
public class UserAppService {

    private final UserDomainService userDomainService;

    public UserDO login(UserDO userDO, String code, String appid) {
        return userDomainService.login(userDO, code, appid);
    }
}
