package com.duanxin.hwjy.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductStockPO
 * @date 2021/03/30 10:30
 */
@Setter
@Getter
public class ProductStockPO {

    private int id;

    private int productId;

    private int specificationId;

    private int attributeId;

    private int stock;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
