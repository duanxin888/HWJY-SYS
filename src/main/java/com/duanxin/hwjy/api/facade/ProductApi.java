package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public ResponseResult addProduct() {
        return ResponseResult.success();
    }
}
