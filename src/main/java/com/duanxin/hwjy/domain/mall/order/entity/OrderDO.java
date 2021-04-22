package com.duanxin.hwjy.domain.mall.order.entity;

import com.duanxin.hwjy.domain.mall.order.entity.valueobject.*;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDO
 * @date 2021/04/13 09:01
 */
@Setter
@Getter
public class OrderDO {

    private int id;

    private int userId;

    private String orderSn;

    private BigDecimal totalPrice;

    private int totalQuantity;

    private OrderStatus orderStatus;

    private AddressInfo addressInfo;

    private PayInfo payInfo;

    private ShipInfo shipInfo;

    private LocalDateTime refundTime;

    private LocalDateTime confirmTime;

    private LocalDateTime orderCloseTime;

    private OrderDetails orderDetails;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();

    private OrderCounts orderCounts;

    public void init(String orderSn) {
        this.setOrderSn(orderSn);
        this.setTotalQuantity(this.getOrderDetails().getProductInfos().stream().
                map(ProductInfo::getQuantity).reduce(0, Integer::sum));
        this.setTotalPrice(this.getOrderDetails().getProductInfos().stream().
                map(ProductInfo::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        this.setOrderStatus(OrderStatus.UNPAY);
    }

    public void cancel() {
        this.setOrderStatus(OrderStatus.CLOSE);
        this.setOrderCloseTime(LocalDateTime.now());
        this.setEdate(LocalDateTime.now());
    }

    public void pay(String paySn) {
        this.setOrderStatus(OrderStatus.PADYED);
        this.setPayInfo(new PayInfo(paySn));
        this.setEdate(LocalDateTime.now());
    }
}
