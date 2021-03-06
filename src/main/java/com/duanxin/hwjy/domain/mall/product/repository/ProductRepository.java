package com.duanxin.hwjy.domain.mall.product.repository;

import com.duanxin.hwjy.domain.mall.product.entity.ProductDO;
import com.github.pagehelper.PageInfo;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductRepository
 * @date 2021/04/02 09:06
 */
public interface ProductRepository {
    int insert(ProductDO productDO);

    ProductDO selectByName(String name);

    PageInfo<ProductDO> getProductsByCid(int cid, int pageNum, int pageSize);

    ProductDO detailsProduct(int id);
}
