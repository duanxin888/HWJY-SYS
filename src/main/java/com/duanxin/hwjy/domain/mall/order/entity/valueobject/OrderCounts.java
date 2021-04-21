package com.duanxin.hwjy.domain.mall.order.entity.valueobject;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderCounts
 * @date 2021/04/21 09:08
 */
@Getter
@Setter
public class OrderCounts {

    private int allCount;

    private int unPay;

    private int payed;

    private int consignment;

    private int confirm;

    private int success;

    private int close;
}
