package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.api.assembler.OrderAssembler;
import com.duanxin.hwjy.api.dto.order.OrderSubmitCommandDto;
import com.duanxin.hwjy.application.service.command.OrderAppService;
import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public ResponseResult submitOrder(@RequestBody @Valid OrderSubmitCommandDto dto) {
        orderAppService.submitOrder(OrderAssembler.submitCommandDto2DO(dto));
        return ResponseResult.success();
    }
}
