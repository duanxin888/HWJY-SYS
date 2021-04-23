package com.duanxin.hwjy.application.service.query;

import com.duanxin.hwjy.domain.mall.product.entity.ProductCategoryDO;
import com.duanxin.hwjy.domain.mall.product.entity.ProductDO;
import com.duanxin.hwjy.domain.mall.product.repository.ProductCategoryRepository;
import com.duanxin.hwjy.domain.mall.product.repository.ProductRepository;
import com.github.pagehelper.PageInfo;
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
    private final ProductRepository productRepository;

    public List<ProductCategoryDO> getCategories() {
        return productCategoryRepository.getCategories();
    }

    public PageInfo<ProductDO> getProductsByCid(int cid, int pageNum, int pageSize) {
        return productRepository.getProductsByCid(cid, pageNum, pageSize);
    }

    public ProductDO detailsProduct(int id) {
        return productRepository.detailsProduct(id);
    }
}
