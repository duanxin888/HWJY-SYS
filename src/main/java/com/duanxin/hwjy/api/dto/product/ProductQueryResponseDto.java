package com.duanxin.hwjy.api.dto.product;

import com.duanxin.hwjy.domain.mall.product.entity.valueobject.TransactionRule;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductQueryResponseDto
 * @date 2021/04/08 09:59
 */
@Setter
@Getter
public class ProductQueryResponseDto {

    private int id;

    private String name;

    private int cid;

    private String picUrl;

    private String productSn;

    private String details;

    private int sorted;

    private TransactionRule transactionRule;

    private String brief;

    private List<ProductAttributeDto> attributeDtos;

    private List<ProductSpecificationDto> specificationDtos;

    private List<ProductStockDto> stockDtos;

    private List<SkuDto> skuList;
}
