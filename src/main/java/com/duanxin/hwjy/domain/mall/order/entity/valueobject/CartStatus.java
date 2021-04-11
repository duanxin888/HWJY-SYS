package com.duanxin.hwjy.domain.mall.order.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className CartStatus
 * @date 2021/04/11 10:08
 */
@Getter
@AllArgsConstructor
public enum CartStatus {

    VALID(0, "VALID"),
    INVALID(1, "INVALID");

    private final int code;
    private final String desc;
}
