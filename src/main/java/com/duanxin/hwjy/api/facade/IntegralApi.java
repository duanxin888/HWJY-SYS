package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.api.assembler.IntegralAssembler;
import com.duanxin.hwjy.api.dto.user.integral.IntegralAddCommandDto;
import com.duanxin.hwjy.application.service.command.IntegralAppService;
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
 * @className IntegralApi
 * @date 2021/02/27 08:40
 */
@RestController
@RequestMapping("/api/v1/integral")
@AllArgsConstructor
@Validated
public class IntegralApi {

    private final IntegralAppService integralAppService;

    @PostMapping
    public ResponseResult collectIntegral(@RequestBody @Valid IntegralAddCommandDto dto) {
        integralAppService.collectIntegral(IntegralAssembler.addCommand2LogDO(dto));
        return ResponseResult.success();
    }
}
