package com.duanxin.hwjy.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserQueryResponseDto
 * @date 2021/01/30 11:36
 */
@Setter
@Getter
public class UserQueryResponseDto {

    private int id;

    private String phone;

    private String userImgUrl;

    private String thirdSession;

    private String integralAccountSn;

    private BigDecimal integralBalance;

    private LocalDateTime integralValidityDate;

    private String nickname;
}
