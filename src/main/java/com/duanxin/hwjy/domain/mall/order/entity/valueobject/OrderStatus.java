package com.duanxin.hwjy.domain.mall.order.entity.valueobject;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderStatus
 * @date 2021/04/13 09:02
 */
public enum OrderStatus {

    /**
     * 没有付款.待付款
     */
    UNPAY,

    /**
     * 已经付款,但卖家没有发货.待发货
     */
    PADYED,

    /**
     * 发货，导致实际库存减少，没有确认收货.待收货
     */
    CONSIGNMENT,

    /**
     * 收货，没有评价.待评价
     */
    CONFIRM,

    /**
     * 评价后交易成功，购买数增加1.
     */
    SUCCESS,

    /**
     * 交易失败.,还原库存
     */
    CLOSE;
}
