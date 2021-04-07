package com.duanxin.hwjy.api.facade.admin;

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
 * @className AdminProductApi
 * @date 2021/04/07 10:07
 */
@RequestMapping("/api/v1/admin/products")
@RestController
@Validated
@AllArgsConstructor
public class AdminProductApi {

    private final ProductAppService productAppService;

    @PostMapping
    public ResponseResult addProduct(@RequestBody @Valid ProductAddCommandDto dto) {
        productAppService.addProduct(ProductAssembler.addCommand2DO(dto));
        return ResponseResult.success();
    }
}
