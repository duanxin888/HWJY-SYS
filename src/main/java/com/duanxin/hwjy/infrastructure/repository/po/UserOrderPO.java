package com.duanxin.hwjy.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserOrderPO
 * @date 2021/04/13 08:51
 */
@Setter
@Getter
public class UserOrderPO {

    private int id;

    private int userId;

    private String orderSn;

    private BigDecimal totalPrice;

    private int totalQuantity;

    private String orderStatus;

    private String addressInfo;

    private String payInfo;

    private String shipInfo;

    private LocalDateTime refundTime;

    private LocalDateTime confirmTime;

    private LocalDateTime orderCloseTime;

    private String orderDetails;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
