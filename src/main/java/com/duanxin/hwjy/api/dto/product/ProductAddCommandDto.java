package com.duanxin.hwjy.api.dto.product;

import com.duanxin.hwjy.domain.mall.product.entity.valueobject.TransactionRule;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductAddCommandDto
 * @date 2021/03/30 19:04
 */
@Setter
@Getter
public class ProductAddCommandDto {

    @NotBlank(message = "name NotBlank")
    private String name;

    private int cid;

    @NotBlank(message = "picUrl NotBlank")
    private String picUrl;

    @NotBlank(message = "details NotBlank")
    private String details;

    @NotNull(message = "transactionRule NotNull")
    private TransactionRule transactionRule;

    @NotBlank(message = "brief NotBlank")
    private String brief;

    private int onSale;

    @NotNull(message = "productSpecification NotNull")
    private List<ProductSpecificationDto> productSpecifications;

    @NotNull(message = "productAttribute NotNull")
    private List<ProductAttributeDto> productAttributes;
}
