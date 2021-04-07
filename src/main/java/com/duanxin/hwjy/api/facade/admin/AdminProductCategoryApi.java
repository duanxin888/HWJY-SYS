package com.duanxin.hwjy.api.facade.admin;

import com.duanxin.hwjy.api.assembler.ProductCategoryAssembler;
import com.duanxin.hwjy.api.dto.product.CategoryAddCommandDto;
import com.duanxin.hwjy.application.service.command.ProductAppService;
import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author duanxin
 * @version 1.0
 * @className AdminProductCategoryApi
 * @date 2021/04/07 10:08
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/admin/products/categories")
public class AdminProductCategoryApi {

    private final ProductAppService productAppService;

    @PostMapping
    public ResponseResult addProductCategory(@RequestBody @Valid CategoryAddCommandDto dto) {
        productAppService.addProductCategory(ProductCategoryAssembler.addCommand2DO(dto));
        return ResponseResult.success();
    }
}
