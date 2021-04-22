package com.duanxin.hwjy.api.assembler;

import com.duanxin.hwjy.api.dto.order.OrderDetailsResponseDto;
import com.duanxin.hwjy.api.dto.order.OrderListResponseDto;
import com.duanxin.hwjy.api.dto.order.OrderPageResponseDto;
import com.duanxin.hwjy.api.dto.order.OrderSubmitCommandDto;
import com.duanxin.hwjy.domain.mall.order.entity.OrderDO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;

import java.util.stream.Collectors;

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

    public static OrderPageResponseDto do2PageResponseDto(PageInfo<OrderDO> orders) {
        OrderPageResponseDto dto = new OrderPageResponseDto();
        dto.setPageNum(orders.getPageNum());
        dto.setPageSize(orders.getPageSize());
        dto.setPages(orders.getPages());
        dto.setOrders(orders.getList().stream().map(OrderAssembler::do2ListResponseDto).collect(Collectors.toList()));
        return dto;
    }

    private static OrderListResponseDto do2ListResponseDto(OrderDO orderDO) {
        OrderListResponseDto dto = new OrderListResponseDto();
        BeanUtils.copyProperties(orderDO, dto);
        dto.setOrderDetails(orderDO.getOrderDetails().getProductInfos());
        dto.setOrderStatus(orderDO.getOrderStatus().getCode());
        return dto;
    }

    public static OrderDetailsResponseDto do2DetailsResponseDto(OrderDO orderDO) {
        OrderDetailsResponseDto dto = new OrderDetailsResponseDto();
        BeanUtils.copyProperties(orderDO, dto);
        dto.setOrderDetails(orderDO.getOrderDetails().getProductInfos());
        dto.setOrderStatus(orderDO.getOrderStatus().getCode());
        return dto;
    }
}
