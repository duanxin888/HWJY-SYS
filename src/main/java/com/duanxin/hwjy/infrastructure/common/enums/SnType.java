package com.duanxin.hwjy.infrastructure.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className SnVersion
 * @date 2021/01/14 10:49
 */
@Getter
@AllArgsConstructor
public enum SnType {

    INTEGRAL_ACCOUNT_SN_TYPE("01"),
    DICTIONARY_SN_TYPE("02"),
    PRODUCT_SN_TYPE("03"),
    ORDER_SN_TYPE("04"),
    PAY_SN("05");

    private final String typeId;
}
