package com.duanxin.hwjy.infrastructure.client.test;

import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className GarbageSortingType
 * @date 2021/03/13 09:32
 */
@AllArgsConstructor
@Getter
public enum TxGarbageSortingType {

    RECYCLABLE_TRASH(0, "可回收垃圾"),
    HAZARDOUS_WASTE(1, "有害垃圾"),
    KITCHEN_WASTE(2, "厨余垃圾"),
    OTHER_GARBAGE(3, "其他垃圾");

    private final int type;
    private final String name;

    public static String fetchNameByType(int type) {
        for (TxGarbageSortingType value : values()) {
            if (type == value.type) {
                return value.name;
            }
        }
        throw new HWJYCheckException(ResultEnum.TEST_COLLECT_BY_THIRD_PARTY_ERROR_CODE);
    }
}
