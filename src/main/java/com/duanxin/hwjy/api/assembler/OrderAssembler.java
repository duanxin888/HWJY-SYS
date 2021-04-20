package com.duanxin.hwjy.api.assembler;

import com.duanxin.hwjy.api.dto.order.OrderSubmitCommandDto;
import com.duanxin.hwjy.domain.mall.order.entity.OrderDO;
import org.springframework.beans.BeanUtils;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderAssembler
 * @date 2021/04/13 16:28
 */
public class OrderAssembler {

    private OrderAssembler() {
    }

    public static OrderDO submitCommandDto2DO(OrderSubmitCommandDto dto) {
        OrderDO orderDO = new OrderDO();
        BeanUtils.copyProperties(dto, orderDO);
        return orderDO;
    }
}
