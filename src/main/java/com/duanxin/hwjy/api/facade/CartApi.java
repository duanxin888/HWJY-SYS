package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.api.assembler.CartEventLogAssembler;
import com.duanxin.hwjy.api.dto.cart.CartUpdateCommandDto;
import com.duanxin.hwjy.application.service.command.CartAppService;
import com.duanxin.hwjy.application.service.query.CartQueryAppService;
import com.duanxin.hwjy.domain.mall.order.entity.UserCartDO;
import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className CartApi
 * @date 2021/04/11 10:54
 */
@RestController
@RequestMapping("/api/v1/carts")
@AllArgsConstructor
@Validated
public class CartApi {

    private final CartAppService cartAppService;
    private final CartQueryAppService cartQueryAppService;

    @PutMapping
    public ResponseResult modifyCart(@RequestBody @Valid CartUpdateCommandDto dto) {
        cartAppService.modifyCart(dto.getUserId(), CartEventLogAssembler.commandDto2DO(dto));
        return ResponseResult.success();
    }

    @GetMapping("/{userId}")
    public ResponseResult getUserCart(@PathVariable int userId) {
        UserCartDO cartDO = cartQueryAppService.getUserCart(userId);
        return ResponseResult.success(cartDO.getEventLogs().stream().
                map(CartEventLogAssembler::do2QueryResDto).
                collect(Collectors.toList()));
    }
}
