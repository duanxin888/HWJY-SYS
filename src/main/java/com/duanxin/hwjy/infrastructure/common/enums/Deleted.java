package com.duanxin.hwjy.infrastructure.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className DELETED
 * @date 2021/01/10 09:47
 */
@Getter
@AllArgsConstructor
public enum Deleted {

    VALID(0, "有效"), INVALID(1, "无效");

    private final int code;
    private final String desc;

    public static boolean isValid(int deleted) {
        return VALID.code == deleted;
    }

    public static Deleted formatByCode(int code) {
        for (Deleted deleted : Deleted.values()) {
            if (code == deleted.getCode()) {
                return deleted;
            }
        }
        return Deleted.INVALID;
    }
}
