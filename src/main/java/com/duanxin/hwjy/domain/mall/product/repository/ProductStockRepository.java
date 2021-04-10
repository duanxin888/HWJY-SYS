package com.duanxin.hwjy.domain.mall.product.repository;

import com.duanxin.hwjy.domain.mall.product.entity.ProductStockDO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductStockRepository
 * @date 2021/04/08 09:04
 */
public interface ProductStockRepository {
    List<ProductStockDO> selectByPid(int pid);
}
