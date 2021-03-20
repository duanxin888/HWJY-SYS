package com.duanxin.hwjy.api.dto.product;

import com.duanxin.hwjy.domain.mall.product.entity.valueobject.CategoryLevel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author duanxin
 * @version 1.0
 * @className CategoryAddCommandDto
 * @date 2021/03/19 09:30
 */
@Setter
@Getter
public class CategoryAddCommandDto {

    private int pid = 0;

    @NotBlank(message = "name NotBlank")
    private String name;

    @NotBlank(message = "picUrl NotBlank")
    private String picUrl;

    @NotNull(message = "Level NotNull")
    private CategoryLevel Level;

    @NotBlank(message = "details NotBlank")
    private String details;

    private int sorted;
}
