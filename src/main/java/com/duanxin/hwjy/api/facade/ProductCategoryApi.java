package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.api.assembler.ProductCategoryAssembler;
import com.duanxin.hwjy.application.service.query.ProductQueryAppService;
import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductCategoryApi
 * @date 2021/03/19 09:27
 */
@RestController
@RequestMapping("/api/v1/products/categories")
@AllArgsConstructor
@Validated
public class ProductCategoryApi {

    private final ProductQueryAppService productQueryAppService;

    @GetMapping
    public ResponseResult getAll() {
        return ResponseResult.success(productQueryAppService.getCategories().stream().
                map(ProductCategoryAssembler::do2QueryResponseDto).
                collect(Collectors.toList()));
    }
}
