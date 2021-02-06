package com.duanxin.hwjy.api.assembler;

import com.duanxin.hwjy.api.dto.user.login.LoginCommandDto;
import com.duanxin.hwjy.api.dto.user.login.LoginResponseDto;
import com.duanxin.hwjy.api.dto.user.UserQueryResponseDto;
import com.duanxin.hwjy.domain.user.entity.IntegralAccountDO;
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

    public static UserQueryResponseDto do2UserQueryResponseDto(UserDO userDO) {
        UserQueryResponseDto dto = new UserQueryResponseDto();
        BeanUtils.copyProperties(userDO, dto);
        IntegralAccountDO integralAccount = userDO.getIntegralAccount();
        dto.setIntegralAccountSn(integralAccount.getIntegralAccountSn());
        dto.setIntegralBalance(integralAccount.getIntegralBalance());
        dto.setIntegralValidityDate(integralAccount.getIntegralValidityDate());
        return dto;
    }
}
