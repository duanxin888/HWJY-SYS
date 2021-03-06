package com.duanxin.hwjy.domain.user.repository;

import com.duanxin.hwjy.domain.user.entity.IntegralAccountDO;
import com.duanxin.hwjy.infrastructure.repository.po.IntegralAccountPO;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralAccountRepository
 * @date 2021/01/14 11:40
 */
public interface IntegralAccountRepository {

    IntegralAccountPO insert(IntegralAccountPO integralAccountPO);

    IntegralAccountDO selectBySn(String integralAccountSn);

    void updateBalanceBySn(String integralAccountSn, BigDecimal integralBalance);

    void update4Consumption(IntegralAccountDO accountDO);
}
