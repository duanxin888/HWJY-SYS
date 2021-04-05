package com.duanxin.hwjy.infrastructure.repository.mapper;

import com.duanxin.hwjy.infrastructure.repository.po.ProductAttributePO;
import org.apache.ibatis.annotations.Param;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductSpecificationMapper
 * @date 2021/03/30 09:59
 */
public interface ProductAttributeMapper {
    void insert(@Param("po") ProductAttributePO po);
}
