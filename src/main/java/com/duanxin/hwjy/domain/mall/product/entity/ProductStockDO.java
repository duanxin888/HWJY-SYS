package com.duanxin.hwjy.domain.mall.product.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductStockDO
 * @date 2021/03/30 10:35
 */
@Setter
@Getter
public class ProductStockDO {

    private int id;

    private int productId;

    private int specificationId;

    private int attributeId;

    private int stock;
}
