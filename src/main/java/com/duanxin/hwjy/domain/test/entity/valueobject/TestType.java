package com.duanxin.hwjy.domain.test.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className TestType
 * @date 2021/03/13 09:15
 */
@Getter
@AllArgsConstructor
public enum TestType {

    SIMPLE_CHOICE(0, "SIMPLE_CHOICE"),
    MULTIPLE_CHOICE(1, "MULTIPLE_CHOICE"),
    JUDGMENT(2, "JUDGMENT"),
    ESSAY_QUESTION(3, "ESSAY_QUESTION");


    private final int code;
    private final String desc;

    public static TestType fetchByCode(int code) {
        for (TestType value : values()) {
            if (code == value.code) {
                return value;
            }
        }
        return SIMPLE_CHOICE;
    }
}
