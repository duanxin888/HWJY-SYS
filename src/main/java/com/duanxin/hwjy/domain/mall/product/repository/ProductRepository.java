package com.duanxin.hwjy.domain.mall.product.repository;

import com.duanxin.hwjy.domain.mall.product.entity.ProductDO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductRepository
 * @date 2021/04/02 09:06
 */
public interface ProductRepository {
    int insert(ProductDO productDO);

    ProductDO selectByName(String name);

    List<ProductDO> getProductsByCid(int cid);
}
