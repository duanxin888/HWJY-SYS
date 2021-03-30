package com.duanxin.hwjy.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductSpecification
 * @date 2021/03/30 09:56
 */
@Setter
@Getter
public class ProductSpecificationPO {

    private int id;

    private int productId;

    private String specification;

    private String value;

    private String gallery;

    private int deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
