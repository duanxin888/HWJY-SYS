package com.duanxin.hwjy.domain.user.repository;

import com.duanxin.hwjy.domain.user.entity.UserDO;
import com.duanxin.hwjy.infrastructure.repository.po.UserPO;

/**
 * @author duanxin
 * @version 1.0
 * @className UserReposService
 * @date 2021/01/14 09:28
 */
public interface UserRepository {

    UserPO selectByOpenId(String openid);

    UserPO insert(UserPO userPO);

    void updateSessionKey(UserPO userPO);

    UserDO selectById(int userId);

    UserDO selectByIntegralAccountSn(String integralAccountSn);
}
