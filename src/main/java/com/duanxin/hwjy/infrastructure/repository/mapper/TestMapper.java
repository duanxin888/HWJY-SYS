package com.duanxin.hwjy.infrastructure.repository.mapper;

import com.duanxin.hwjy.infrastructure.repository.po.TestPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author duanxin
 * @version 1.0
 * @className TestMapper
 * @date 2021/03/13 09:10
 */
public interface TestMapper {

    void insert(@Param("po") TestPO po);
}
