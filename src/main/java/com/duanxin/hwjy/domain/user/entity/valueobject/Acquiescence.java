package com.duanxin.hwjy.domain.user.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className Acquiescence
 * @date 2021/01/10 09:54
 */
@Getter
@AllArgsConstructor
public enum Acquiescence {

    ACQUIESCENCE(0, "默认地址"), NOT_ACQUIESCENCE(1, "非默认地址");

    private final int code;
    private final String desc;
}
