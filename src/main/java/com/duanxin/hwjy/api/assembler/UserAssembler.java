package com.duanxin.hwjy.api.assembler;

import com.duanxin.hwjy.api.dto.LoginCommandDto;
import com.duanxin.hwjy.api.dto.LoginResponseDto;
import com.duanxin.hwjy.domain.user.entity.UserDO;
import org.springframework.beans.BeanUtils;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAssembler
 * @date 2021/01/10 08:20
 */
public class UserAssembler {

    private UserAssembler() {}

    public static UserDO loginCommand2DO(LoginCommandDto dto) {
        UserDO userDO = new UserDO();
        userDO.setNickname(dto.getNickname());
        userDO.setUserImgUrl(dto.getAvatarUrl());
        return userDO;
    }

    public static LoginResponseDto do2LoginResponse(UserDO userDO, LoginCommandDto dto) {
        LoginResponseDto response = new LoginResponseDto();
        BeanUtils.copyProperties(userDO, response);
        BeanUtils.copyProperties(userDO.getIntegralAccount(), response);
        BeanUtils.copyProperties(dto, response);
        return response;
    }
}
