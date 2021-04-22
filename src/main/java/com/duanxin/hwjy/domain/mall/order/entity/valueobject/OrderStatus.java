package com.duanxin.hwjy.domain.mall.order.entity.valueobject;

import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderStatus
 * @date 2021/04/13 09:02
 */
@Getter
@AllArgsConstructor
public enum OrderStatus {

    /**
     * 没有付款.待付款
     */
    UNPAY(1, "UNPAY"),

    /**
     * 已经付款,但卖家没有发货.待发货
     */
    PADYED(2, "PADYED"),

    /**
     * 发货，导致实际库存减少，没有确认收货.待收货
     */
    CONSIGNMENT(3, "CONSIGNMENT"),

    /**
     * 收货，没有评价.待评价
     */
    CONFIRM(4, "CONFIRM"),

    /**
     * 评价后交易成功，购买数增加1.
     */
    SUCCESS(5, "SUCCESS"),

    /**
     * 交易失败.,还原库存
     */
    CLOSE(6, "CLOSE"),

    /**
     * 所有订单
     * */
    ALL(0, "ALL"),

    /**
     * 订单已删除
     * */
    DELETED(7, "DELETED");

    private final int code;
    private final String desc;

    public static OrderStatus fetchByName(String name) {
        for (OrderStatus value : values()) {
            if (value.name().equals(name)) {
                return value;
            }
        }
        throw new HWJYCheckException(ResultEnum.USER_ORDER_STATUS_NOT_EXIST);
    }

    public static boolean checkValid(OrderStatus orderStatus) {
        return !DELETED.equals(orderStatus);
    }
}
