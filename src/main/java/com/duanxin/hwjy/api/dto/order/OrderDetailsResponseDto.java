package com.duanxin.hwjy.api.dto.order;

import com.duanxin.hwjy.domain.mall.order.entity.valueobject.AddressInfo;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.PayInfo;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.ProductInfo;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.ShipInfo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDetailsResponseDto
 * @date 2021/04/22 18:53
 */
@Setter
@Getter
public class OrderDetailsResponseDto {

    private String orderSn;

    private BigDecimal totalPrice;

    private int totalQuantity;

    private int orderStatus;

    private AddressInfo addressInfo;

    private PayInfo payInfo;

    private ShipInfo shipInfo;

    private LocalDateTime refundTime;

    private LocalDateTime confirmTime;

    private LocalDateTime orderCloseTime;

    private List<ProductInfo> orderDetails;
}
