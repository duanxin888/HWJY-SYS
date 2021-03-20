package com.duanxin.hwjy.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductCategoryPO
 * @date 2021/03/19 09:11
 */
@Setter
@Getter
public class ProductCategoryPO {

    private int id;

    private int pid;

    private String name;

    private String picUrl;

    private String level;

    private String details;

    private int sorted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
