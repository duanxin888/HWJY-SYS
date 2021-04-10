package com.duanxin.hwjy.domain.mall.product.repository;

import com.duanxin.hwjy.domain.mall.product.entity.ProductAttributeDO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductAttributeRepository
 * @date 2021/04/02 09:20
 */
public interface ProductAttributeRepository {
    void insert(ProductAttributeDO attribute);

    List<ProductAttributeDO> selectByPid(int pid);
}
