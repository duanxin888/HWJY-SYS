package com.duanxin.hwjy.api.dto.product;

import com.duanxin.hwjy.domain.mall.product.entity.valueobject.TransactionRule;
import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductsQueryResponseDto
 * @date 2021/04/07 10:01
 */
@Setter
@Getter
public class ProductsQueryDto {

    private int id;

    private String name;

    private int cid;

    private String picUrl;

    private String productSn;

    private String details;

    private int sorted;

    private TransactionRule transactionRule;

    private String brief;
}
