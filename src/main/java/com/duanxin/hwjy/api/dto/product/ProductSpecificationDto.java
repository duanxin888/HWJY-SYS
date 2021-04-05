package com.duanxin.hwjy.api.dto.product;

import com.duanxin.hwjy.domain.mall.product.entity.valueobject.ProductGallery;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductSpecificationDto
 * @date 2021/04/01 20:17
 */
@Setter
@Getter
public class ProductSpecificationDto {

    int id;

    private int productId;

    private String specification;

    private String value;

    private List<ProductGallery> galleries;
}
