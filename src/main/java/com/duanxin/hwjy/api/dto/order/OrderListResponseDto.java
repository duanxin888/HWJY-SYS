package com.duanxin.hwjy.api.dto.order;

import com.duanxin.hwjy.domain.mall.order.entity.valueobject.ProductInfo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderListResponseDto
 * @date 2021/04/21 15:37
 */
@Setter
@Getter
public class OrderListResponseDto {

    private int id;

    private String orderSn;

    private BigDecimal totalPrice;

    private int totalQuantity;

    private int orderStatus;

    private List<ProductInfo> orderDetails;
}
