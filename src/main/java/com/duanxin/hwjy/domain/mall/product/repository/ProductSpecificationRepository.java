package com.duanxin.hwjy.domain.mall.product.repository;

import com.duanxin.hwjy.domain.mall.product.entity.ProductSpecificationDO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductSpecificationRepository
 * @date 2021/04/02 09:18
 */
public interface ProductSpecificationRepository {
    void insert(ProductSpecificationDO specification);

    List<ProductSpecificationDO> selectByPid(int pid);
}
