package com.duanxin.hwjy.infrastructure.repository.mapper;

import com.duanxin.hwjy.infrastructure.repository.po.IntegralAccountPO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralAccountMapper
 * @date 2021/01/10 08:56
 */
public interface IntegralAccountMapper {
    void insert(@Param("integralAccount") IntegralAccountPO integralAccountPO);

    IntegralAccountPO selectBySn(@Param("integralAccountSn") String integralAccountSn);

    void updateBalanceBySn(@Param("integralAccountSn") String integralAccountSn,
                           @Param("integralBalance") BigDecimal integralBalance);
}
