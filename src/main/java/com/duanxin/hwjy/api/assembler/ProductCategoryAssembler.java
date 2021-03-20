package com.duanxin.hwjy.api.assembler;

import com.duanxin.hwjy.api.dto.product.CategoryAddCommandDto;
import com.duanxin.hwjy.api.dto.product.CategoryQueryResponseDto;
import com.duanxin.hwjy.domain.mall.product.entity.ProductCategoryDO;
import org.springframework.beans.BeanUtils;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductCategoryAssembler
 * @date 2021/03/19 09:35
 */
public class ProductCategoryAssembler {

    private ProductCategoryAssembler() {
    }

    public static ProductCategoryDO addCommand2DO(CategoryAddCommandDto dto) {
        ProductCategoryDO categoryDO = new ProductCategoryDO();
        BeanUtils.copyProperties(dto, categoryDO);
        return categoryDO;
    }

    public static CategoryQueryResponseDto do2QueryResponseDto(ProductCategoryDO categoryDO) {
        CategoryQueryResponseDto dto = new CategoryQueryResponseDto();
        BeanUtils.copyProperties(categoryDO, dto);
        return dto;
    }
}
