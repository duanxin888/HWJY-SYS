package com.duanxin.hwjy.api.dto.product;

import com.duanxin.hwjy.domain.mall.product.entity.valueobject.CategoryLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className CategoryQueryResponseDto
 * @date 2021/03/19 10:55
 */
@Setter
@Getter
public class CategoryQueryResponseDto {

    private int id;

    private int pid;

    private String name;

    private String picUrl;

    private CategoryLevel level = CategoryLevel.L0;

    private String details;

    private int sorted;
}
