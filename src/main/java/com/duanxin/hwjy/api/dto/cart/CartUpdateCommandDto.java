package com.duanxin.hwjy.api.dto.cart;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className CartUpdateCommandDto
 * @date 2021/04/11 14:34
 */
@Setter
@Getter
public class CartUpdateCommandDto {

    @NotNull(message = "userId NotNull")
    private Integer userId;

    @NotBlank(message = "productSn NotBlank")
    private String productSn;

    @NotBlank(message = "name NotBlank")
    private String name;

    @NotBlank(message = "picUrl NotBlank")
    private String picUrl;

    @NotBlank(message = "specification NotBlank")
    private String specification;

    @NotBlank(message = "specValue NotBlank")
    private String specValue;

    @NotBlank(message = "attribute NotBlank")
    private String attribute;

    @NotBlank(message = "attValue NotBlank")
    private String attValue;

    @NotNull(message = "price NotNull")
    private BigDecimal price;

    @NotNull(message = "quantity NotNull")
    private Integer quantity;

    @NotNull(message = "operateType NotNull")
    private Integer operateType;
}
