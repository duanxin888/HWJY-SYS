package com.duanxin.hwjy.domain.mall.order.entity.valueobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductInfo
 * @date 2021/04/11 10:10
 */
@Setter
@Getter
@EqualsAndHashCode(exclude = "quantity")
public class ProductInfo {

    private String productSn;

    private String name;

    private String picUrl;

    private BigDecimal price;

    private int quantity;

    private String specification;

    private String specValue;

    private String attribute;

    private String attValue;
}
