package com.duanxin.hwjy.domain.user.service.impl;

import com.duanxin.hwjy.domain.user.entity.IntegralAccountDO;
import com.duanxin.hwjy.domain.user.entity.IntegralLogDO;
import com.duanxin.hwjy.domain.user.repository.IntegralAccountRepository;
import com.duanxin.hwjy.domain.user.repository.IntegralLogRepository;
import com.duanxin.hwjy.domain.user.service.IntegralDomainService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralDomainServiceImpl
 * @date 2021/03/02 10:41
 */
@Service
@AllArgsConstructor
@Slf4j
public class IntegralDomainServiceImpl implements IntegralDomainService {

    private final IntegralAccountRepository integralAccountRepository;
    private final IntegralLogRepository integralLogRepository;

    @Override
    public IntegralAccountDO selectBySn(String integralAccountSn) {
        return integralAccountRepository.selectBySn(integralAccountSn);
    }

    @Override
    @Transactional
    public void collectIntegral(IntegralLogDO logDO, BigDecimal integralNumber) {
        // update account
        IntegralAccountDO integralAccountDO = integralAccountRepository.selectBySn(logDO.getIntegralAccountSn());
        integralAccountDO.increaseIncome(integralNumber);
        integralAccountRepository.updateBalanceBySn(integralAccountDO.getIntegralAccountSn(),
                integralAccountDO.getIntegralBalance());
        // append log
        logDO.create4Collect(integralNumber);
        integralLogRepository.insert(logDO);
    }

    @Override
    public void checkIntegralValidity(IntegralLogDO logDO) {
        integralLogRepository.checkIntegralValidity(logDO);
    }
}
