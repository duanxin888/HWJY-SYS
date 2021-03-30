package com.duanxin.hwjy.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductAttributePO
 * @date 2021/03/30 10:10
 */
@Setter
@Getter
public class ProductAttributePO {

    private int id;

    private int productId;

    private String attribute;

    private String value;

    private int deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
