package com.duanxin.hwjy.domain.user.service;

import com.duanxin.hwjy.domain.user.entity.IntegralAccountDO;
import com.duanxin.hwjy.domain.user.entity.IntegralLogDO;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralDomainService
 * @date 2021/03/02 10:40
 */
public interface IntegralDomainService {

    IntegralAccountDO selectBySn(String integralAccountSn);

    void collectIntegral(IntegralLogDO logDO, BigDecimal integralNumber);

    void checkIntegralValidity(IntegralLogDO logDO);

    void consumptionIntegral(IntegralAccountDO accountDO, BigDecimal integralNumber);

    void appendConsumptionLog(IntegralAccountDO accountDO, BigDecimal integralNumber,
                              String operateParam, int userId);
}
