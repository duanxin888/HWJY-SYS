package com.duanxin.hwjy.infrastructure.repository;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderCountsDto
 * @date 2021/04/21 09:33
 */
@Setter
@Getter
public class OrderCountsDto {

    private int allCount;

    private int unPay;

    private int payed;

    private int consignment;

    private int confirm;

    private int success;

    private int close;
}
