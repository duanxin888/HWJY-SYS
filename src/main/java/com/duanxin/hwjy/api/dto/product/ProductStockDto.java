package com.duanxin.hwjy.api.dto.product;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductStockDto
 * @date 2021/04/08 10:14
 */
@Setter
@Getter
public class ProductStockDto {

    private int id;

    private int productId;

    private int specificationId;

    private int attributeId;

    private int stock;
}
