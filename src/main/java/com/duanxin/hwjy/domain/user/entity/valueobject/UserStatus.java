package com.duanxin.hwjy.domain.user.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className UserStatus
 * @date 2021/01/10 09:43
 */
@Getter
@AllArgsConstructor
public enum UserStatus {

    AVAILABLE(0, "可用"), DISABLE(1, "禁用"), LOGOUT(2, "注销");

    private final int code;
    private final String desc;
}
