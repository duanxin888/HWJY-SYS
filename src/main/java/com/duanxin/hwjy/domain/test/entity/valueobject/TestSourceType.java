package com.duanxin.hwjy.domain.test.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className NewsSourceType
 * @date 2021/02/08 10:13
 */
@Getter
@AllArgsConstructor
public enum TestSourceType {

    THIRD_PARTY(0, "THIRD_PARTY"), SYSTEM_ADMIN(1, "SYSTEM_ADMIN");

    private final int code;
    private final String type;
}
