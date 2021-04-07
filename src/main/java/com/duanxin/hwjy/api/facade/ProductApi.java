package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.api.assembler.ProductAssembler;
import com.duanxin.hwjy.api.dto.product.ProductAddCommandDto;
import com.duanxin.hwjy.application.service.command.ProductAppService;
import com.duanxin.hwjy.application.service.query.ProductQueryAppService;
import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

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
    private final ProductQueryAppService productQueryAppService;

    @PostMapping
    public ResponseResult addProduct(@RequestBody @Valid ProductAddCommandDto dto) {
        productAppService.addProduct(ProductAssembler.addCommand2DO(dto));
        return ResponseResult.success();
    }

    @GetMapping("/category/{cid}")
    public ResponseResult getProductsByCid(@PathVariable int cid) {
        return ResponseResult.success(productQueryAppService.getProductsByCid(cid).
                stream().map(ProductAssembler::do2ProductsQueryResponseDto).
                collect(Collectors.toList()));
    }
}
