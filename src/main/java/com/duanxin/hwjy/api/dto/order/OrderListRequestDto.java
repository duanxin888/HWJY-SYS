package com.duanxin.hwjy.api.dto.order;

import com.duanxin.hwjy.domain.mall.order.entity.valueobject.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderListRequestDto
 * @date 2021/04/21 15:27
 */
@Setter
@Getter
public class OrderListRequestDto {

    @NotNull(message = "userId NotNull")
    private Integer userId;

    @NotNull(message = "orderStatus NotNull")
    private OrderStatus orderStatus;

    @NotNull(message = "pageNum NotNull")
    private Integer pageNum;

    @NotNull(message = "pageSize NotNull")
    private Integer pageSize;
}
