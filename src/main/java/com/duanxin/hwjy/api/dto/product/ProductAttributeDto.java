package com.duanxin.hwjy.api.dto.product;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductAttributeDto
 * @date 2021/04/01 20:19
 */
@Setter
@Getter
public class ProductAttributeDto {
    
    int id;
    
    private int productId;
    
    private String attribute;
    
    private String value;
}
