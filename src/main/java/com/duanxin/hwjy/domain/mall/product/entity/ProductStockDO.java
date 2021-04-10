package com.duanxin.hwjy.domain.mall.product.entity;

import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();
}
