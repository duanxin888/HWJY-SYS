package com.duanxin.hwjy.domain.user.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralAccountStatus
 * @date 2021/01/10 09:59
 */
@Getter
@AllArgsConstructor
public enum IntegralAccountStatus {

    AVAILABLE(0, "可用"), DISABLE(1, "禁用");

    private final int code;
    private final String desc;

    public static boolean isAvailable(int status) {
        return AVAILABLE.code == status;
    }
}
