package com.duanxin.hwjy.api.dto.cart;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className CartQueryResponseDto
 * @date 2021/04/12 17:55
 */
@Setter
@Getter
public class CartQueryResponseDto {

    private int cartId;

    private String productSn;

    private String name;

    private String picUrl;

    private BigDecimal price;

    private String specification;

    private String specValue;

    private String attribute;

    private String attValue;

    private int quantity;
}
