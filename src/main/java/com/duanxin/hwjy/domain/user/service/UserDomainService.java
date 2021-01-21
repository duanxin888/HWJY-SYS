package com.duanxin.hwjy.domain.user.service;

import com.duanxin.hwjy.domain.user.entity.UserDO;

/**
 * @author duanxin
 * @version 1.0
 * @className UserDomainService
 * @date 2021/01/14 08:56
 */
public interface UserDomainService {

    UserDO login(UserDO userDO, String code, String appid);
}
