package com.duanxin.hwjy.api.dto.user.login;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className LoginResponseDto
 * @date 2021/01/21 10:39
 */
@Setter
@Getter
public class LoginResponseDto {

    private int id;

    private String phone;

    private String userImgUrl;

    private String thirdSession;

    private String integralAccountSn;

    private BigDecimal integralBalance;

    private LocalDateTime integralValidityDate;

    private String nickname;

    private String country;

    private String province;

    private String city;

    private String language;
}
