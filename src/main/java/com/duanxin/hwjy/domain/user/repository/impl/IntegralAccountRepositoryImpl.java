package com.duanxin.hwjy.domain.user.repository.impl;

import com.duanxin.hwjy.domain.user.entity.valueobject.IntegralAccountStatus;
import com.duanxin.hwjy.domain.user.repository.IntegralAccountRepository;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import com.duanxin.hwjy.infrastructure.repository.mapper.IntegralAccountMapper;
import com.duanxin.hwjy.infrastructure.repository.po.IntegralAccountPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralAccountRepositoryImpl
 * @date 2021/01/14 11:40
 */
@Repository
@AllArgsConstructor
@Slf4j
public class IntegralAccountRepositoryImpl implements IntegralAccountRepository {

    private final IntegralAccountMapper integralAccountMapper;

    @Override
    public IntegralAccountPO insert(IntegralAccountPO integralAccountPO) {
        integralAccountMapper.insert(integralAccountPO);
        log.info("success to insert integralAccount [{}]", JsonUtil.toString(integralAccountPO));
        return integralAccountPO;
    }

    @Override
    public IntegralAccountPO selectBySn(String integralAccountSn) {
        IntegralAccountPO integralAccount = integralAccountMapper.selectBySn(integralAccountSn);
        if (!IntegralAccountStatus.isAvailable(integralAccount.getStatus()) ||
                !Deleted.isValid(integralAccount.getDeleted())) {
            log.warn("integralAccount [{}] is not available", JsonUtil.toString(integralAccount));
            throw new HWJYCheckException(ResultEnum.INTEGRAL_ACCOUNT_IS_NOT_AVAILABLE);
        }
        return integralAccount;
    }
}
