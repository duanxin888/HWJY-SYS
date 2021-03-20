package com.duanxin.hwjy.domain.mall.product.entity.valueobject;

/**
 * @author duanxin
 * @version 1.0
 * @className CategoryLevel
 * @date 2021/03/19 09:22
 */
public enum CategoryLevel {

    L0, L1, L2;

    public static CategoryLevel formatByName(String name) {
        for (CategoryLevel value : values()) {
            if (value.name().equals(name)) {
                return value;
            }
        }
        return L0;
    }
}
