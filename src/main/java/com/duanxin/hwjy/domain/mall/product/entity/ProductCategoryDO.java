package com.duanxin.hwjy.domain.mall.product.entity;

import com.duanxin.hwjy.domain.mall.product.entity.valueobject.CategoryLevel;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductCategoryDO
 * @date 2021/03/19 09:18
 */
@Getter
@Setter
public class ProductCategoryDO {

    private int id;

    private int pid;

    private String name;

    private String picUrl;

    private CategoryLevel level = CategoryLevel.L0;

    private String details;

    private int sorted;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();
}
