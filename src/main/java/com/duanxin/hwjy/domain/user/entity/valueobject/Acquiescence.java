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

    public static Acquiescence formatByCode(int code) {
        for (Acquiescence acquiescence : Acquiescence.values()) {
            if (code == acquiescence.getCode()) {
                return acquiescence;
            }
        }
        return Acquiescence.NOT_ACQUIESCENCE;
    }

    public static Acquiescence formatByDesc(String desc) {
        for (Acquiescence acquiescence : Acquiescence.values()) {
            if (desc.equals(acquiescence.getDesc())) {
                return acquiescence;
            }
        }
        return NOT_ACQUIESCENCE;
    }
}
