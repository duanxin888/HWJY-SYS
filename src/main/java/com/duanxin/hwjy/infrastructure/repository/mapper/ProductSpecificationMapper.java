package com.duanxin.hwjy.infrastructure.repository.mapper;

import com.duanxin.hwjy.infrastructure.repository.po.ProductSpecificationPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductSpecificationMapper
 * @date 2021/03/30 09:59
 */
public interface ProductSpecificationMapper {
    void insert(@Param("po") ProductSpecificationPO po);

    List<ProductSpecificationPO> selectByPid(@Param("pid") int pid);
}
