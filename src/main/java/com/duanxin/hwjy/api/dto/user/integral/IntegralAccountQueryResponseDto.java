package com.duanxin.hwjy.api.dto.user.integral;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralAccountQueryResponseDto
 * @date 2021/04/22 15:10
 */
@Setter
@Getter
public class IntegralAccountQueryResponseDto {

    private String integralAccountSn;

    private BigDecimal integralBalance;

    private LocalDateTime integralValidityDate;
}
