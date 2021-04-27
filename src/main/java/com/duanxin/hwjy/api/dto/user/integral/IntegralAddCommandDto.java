package com.duanxin.hwjy.api.dto.user.integral;

import com.duanxin.hwjy.domain.user.entity.valueobject.IntegralOperateChannel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralAddCommandDto
 * @date 2021/03/02 10:16
 */
@Getter
@Setter
public class IntegralAddCommandDto {

    private int userId;

    @NotBlank(message = "integralAccountSn NotBlank")
    private String integralAccountSn;

    @NotNull(message = "integralOperateChannel NotNull")
    private IntegralOperateChannel integralOperateChannel;

    @NotBlank(message = "operateParam NotBlank")
    private String operateParam;

    private BigDecimal integralNumber;
}
