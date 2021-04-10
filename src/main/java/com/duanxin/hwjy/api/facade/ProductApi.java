package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.api.assembler.ProductAssembler;
import com.duanxin.hwjy.application.service.query.ProductQueryAppService;
import com.duanxin.hwjy.domain.mall.product.entity.ProductDO;
import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private final ProductQueryAppService productQueryAppService;

    @GetMapping("/category/{cid}")
    public ResponseResult getProductsByCid(@PathVariable int cid,
                                           int pageNum, int pageSize) {
        return ResponseResult.success(productQueryAppService.getProductsByCid(cid, pageNum, pageSize).
                stream().map(ProductAssembler::do2ProductsQueryResponseDto).
                collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseResult detailsProduct(@PathVariable int id) {
        ProductDO productDO = productQueryAppService.detailsProduct(id);
        return ResponseResult.success(ProductAssembler.do2ProductQueryResponseDto(productDO));
    }
}
