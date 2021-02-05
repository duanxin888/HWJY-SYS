package com.duanxin.hwjy.infrastructure.repository.mapper;

import com.duanxin.hwjy.infrastructure.repository.po.UserPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author duanxin
 * @version 1.0
 * @className UserMapper
 * @date 2021/01/10 08:38
 */
public interface UserMapper {
    UserPO selectByOpenId(@Param("openid") String openid);

    void insert(@Param("user") UserPO userPO);

    void updateSessionKey(@Param("id") int id,
                          @Param("wxSessionKey") String wxSessionKey);

    UserPO selectById(@Param("userId") int userId);
}
