package com.duanxin.hwjy.domain.mall.order.entity.valueobject;

import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className CartStatus
 * @date 2021/04/11 10:08
 */
@Getter
@AllArgsConstructor
public enum CartStatus {

    VALID(0, "VALID"),
    INVALID(1, "INVALID");

    private final int code;
    private final String desc;

    public static CartStatus formatByCode(int cartStatus) {
        for (CartStatus value : values()) {
            if (value.code == cartStatus) {
                return value;
            }
        }
        throw new HWJYCheckException(ResultEnum.CART_STATUS_CODE_NOT_EXIST);
    }
}
