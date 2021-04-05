package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.api.assembler.ProductAssembler;
import com.duanxin.hwjy.api.dto.product.ProductAddCommandDto;
import com.duanxin.hwjy.application.service.command.ProductAppService;
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
 * @className ProductApi
 * @date 2021/03/29 10:48
 */
@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
@Validated
public class ProductApi {

    private final ProductAppService productAppService;

    @PostMapping
    public ResponseResult addProduct(@RequestBody @Valid ProductAddCommandDto dto) {
        productAppService.addProduct(ProductAssembler.addCommand2DO(dto));
        return ResponseResult.success();
    }
}
