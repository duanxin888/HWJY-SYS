package com.duanxin.hwjy.application.service.command;

import com.duanxin.hwjy.domain.mall.product.entity.ProductCategoryDO;
import com.duanxin.hwjy.domain.mall.product.service.ProductDomainService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductAppService
 * @date 2021/03/19 09:27
 */
@Service
@AllArgsConstructor
public class ProductAppService {

    private final ProductDomainService productDomainService;

    public void addProductCategory(ProductCategoryDO categoryDO) {
        productDomainService.addProductCategory(categoryDO);
    }
}
