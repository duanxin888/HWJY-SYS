package com.duanxin.hwjy.api.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductsPageResponseDto
 * @date 2021/04/23 10:10
 */
@Setter
@Getter
public class ProductsPageResponseDto {

    private int pageNum;

    private int pageSize;

    private int pages;

    private List<ProductsQueryDto> productsQueryDtos;
}
