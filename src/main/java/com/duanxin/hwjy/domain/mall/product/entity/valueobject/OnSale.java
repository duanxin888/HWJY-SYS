package com.duanxin.hwjy.domain.mall.product.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className OnSale
 * @date 2021/03/30 11:16
 */
@Getter
@AllArgsConstructor
public enum OnSale {

    ON_SALE(0, "ON_SALE"),
    OFF_SALE(1, "OFF_SALE");

    private final int code;
    private final String desc;

    public static OnSale formatByCode(int code) {
        for (OnSale value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        return ON_SALE;
    }

    public static boolean isOnSale(int code) {
        return ON_SALE.code == code;
    }
}
