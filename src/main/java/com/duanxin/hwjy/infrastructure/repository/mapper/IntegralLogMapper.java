package com.duanxin.hwjy.infrastructure.repository.mapper;

import com.duanxin.hwjy.domain.user.entity.IntegralLogDO;
import com.duanxin.hwjy.infrastructure.repository.po.IntegralLogPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralLogMapper
 * @date 2021/02/27 08:44
 */
public interface IntegralLogMapper {
    void insert(@Param("po") IntegralLogPO po);

    IntegralLogPO checkIntegralValidity(@Param("logDO") IntegralLogDO logDO);
}
