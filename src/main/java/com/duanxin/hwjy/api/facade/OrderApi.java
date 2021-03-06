package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.api.assembler.OrderAssembler;
import com.duanxin.hwjy.api.dto.order.OrderListRequestDto;
import com.duanxin.hwjy.api.dto.order.OrderPayRequestDto;
import com.duanxin.hwjy.api.dto.order.OrderSubmitCommandDto;
import com.duanxin.hwjy.application.service.command.OrderAppService;
import com.duanxin.hwjy.application.service.query.OrderQueryAppService;
import com.duanxin.hwjy.domain.mall.order.entity.OrderDO;
import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderApi
 * @date 2021/04/13 16:17
 */
@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
@Validated
public class OrderApi {

    private final OrderAppService orderAppService;
    private final OrderQueryAppService orderQueryAppService;

    @PostMapping
    public ResponseResult submitOrder(@RequestBody @Valid OrderSubmitCommandDto dto) {
        return ResponseResult.success(OrderAssembler.do2DetailsResponseDto(
                orderAppService.submitOrder(OrderAssembler.submitCommandDto2DO(dto))));
    }

    @GetMapping("/counts/{userId}")
    public ResponseResult orderCounts(@PathVariable int userId) {
        return ResponseResult.success(orderQueryAppService.orderCounts(userId));
    }

    @GetMapping("/list")
    public ResponseResult listOrder(OrderListRequestDto dto) {
        PageInfo<OrderDO> orders = orderQueryAppService.listOrder(dto.getUserId(), dto.getOrderStatus(),
                dto.getPageNum(), dto.getPageSize());
        return ResponseResult.success(OrderAssembler.do2PageResponseDto(orders));
    }

    @PutMapping("/cancel/{orderSn}")
    public ResponseResult cancelOrder(@PathVariable String orderSn) {
        orderAppService.cancelOrder(orderSn);
        return ResponseResult.success();
    }

    @PutMapping("/pay")
    public ResponseResult payOrder(@RequestBody OrderPayRequestDto dto) {
        orderAppService.payOrder(dto.getIntegralAccountSn(), dto.getOrderSn());
        return ResponseResult.success();
    }

    @GetMapping("/{orderSn}")
    public ResponseResult detailsOrder(@PathVariable String orderSn) {
        return ResponseResult.success(OrderAssembler.do2DetailsResponseDto(
                orderQueryAppService.detailsOrder(orderSn)));
    }

    @DeleteMapping("/{orderSn}")
    public ResponseResult deletedOrder(@PathVariable String orderSn) {
        orderAppService.deletedOrder(orderSn);
        return ResponseResult.success();
    }
}
