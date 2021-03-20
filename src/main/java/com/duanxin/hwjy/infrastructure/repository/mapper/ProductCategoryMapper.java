package com.duanxin.hwjy.infrastructure.repository.mapper;

import com.duanxin.hwjy.infrastructure.repository.po.ProductCategoryPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductCategoryMapper
 * @date 2021/03/19 09:13
 */
public interface ProductCategoryMapper {
    void insert(@Param("po") ProductCategoryPO po);

    List<ProductCategoryPO> selectAll();
}
