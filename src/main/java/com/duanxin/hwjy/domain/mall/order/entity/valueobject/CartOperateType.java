package com.duanxin.hwjy.domain.mall.order.entity.valueobject;

import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className CartOperateType
 * @date 2021/04/11 10:22
 */
@Getter
@AllArgsConstructor
public enum CartOperateType {

    PRODUCT_ADD(0, "PRODUCT_ADD"),
    PRODUCT_DELETED(1, "PRODUCT_DELETED");

    private final int code;
    private final String desc;

    public static CartOperateType formatByCode(Integer operateType) {
        for (CartOperateType value : values()) {
            if (value.code == operateType) {
                return value;
            }
        }
        throw new HWJYCheckException(ResultEnum.CART_OPERATE_TYPE_CODE_ERROR);
    }
}
