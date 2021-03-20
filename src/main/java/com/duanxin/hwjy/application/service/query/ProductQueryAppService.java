package com.duanxin.hwjy.application.service.query;

import com.duanxin.hwjy.domain.mall.product.entity.ProductCategoryDO;
import com.duanxin.hwjy.domain.mall.product.repository.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductQueryAppService
 * @date 2021/03/19 10:49
 */
@Service
@AllArgsConstructor
public class ProductQueryAppService {

    private final ProductCategoryRepository productCategoryRepository;

    public List<ProductCategoryDO> getCategories() {
        return productCategoryRepository.getCategories();
    }
}
