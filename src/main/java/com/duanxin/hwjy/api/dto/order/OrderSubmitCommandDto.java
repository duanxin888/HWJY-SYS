package com.duanxin.hwjy.api.dto.order;

import com.duanxin.hwjy.domain.mall.order.entity.valueobject.AddressInfo;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.OrderDetails;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderSubmitCommandDto
 * @date 2021/04/13 16:22
 */
@Getter
@Setter
public class OrderSubmitCommandDto {

    @NotNull(message = "userId NotNull")
    private Integer userId;

    @NotNull(message = "addressInfo NotNull")
    private AddressInfo addressInfo;

    @NotNull(message = "orderDetails NotNull")
    private OrderDetails orderDetails;

    @NotNull(message = "orderEntry NotNull")
    private Integer orderEntry;
}
