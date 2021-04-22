package com.duanxin.hwjy.api.dto.order;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderPayRequestDto
 * @date 2021/04/22 14:14
 */
@Setter
@Getter
public class OrderPayRequestDto {

    private String integralAccountSn;

    private String orderSn;
}
