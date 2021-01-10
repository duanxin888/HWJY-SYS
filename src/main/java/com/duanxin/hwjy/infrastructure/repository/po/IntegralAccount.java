package com.duanxin.hwjy.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralAccount
 * @date 2021/01/10 08:54
 */
@Setter
@Getter
public class IntegralAccount {

    private int id;

    private String integralAccountSn;

    private BigDecimal integralBalance;

    private LocalDateTime integralValidityDate;

    private int status;

    private int deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
