package com.duanxin.hwjy.domain.user.repository.impl;

import com.duanxin.hwjy.domain.user.entity.IntegralLogDO;
import com.duanxin.hwjy.domain.user.repository.IntegralLogRepository;
import com.duanxin.hwjy.domain.user.service.impl.factory.IntegralFactory;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import com.duanxin.hwjy.infrastructure.repository.mapper.IntegralLogMapper;
import com.duanxin.hwjy.infrastructure.repository.po.IntegralLogPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralLogRepositoryImpl
 * @date 2021/03/02 11:23
 */
@Repository
@AllArgsConstructor
@Slf4j
public class IntegralLogRepositoryImpl implements IntegralLogRepository {

    private final IntegralLogMapper integralLogMapper;
    private final IntegralFactory integralFactory;

    @Override
    public void insert(IntegralLogDO logDO) {
        integralLogMapper.insert(integralFactory.createIntegralLogPO(logDO));
        log.info("success to insert IntegralLog [{}]", JsonUtil.toString(logDO));
    }

    @Override
    public void checkIntegralValidity(IntegralLogDO logDO) {
        IntegralLogPO po = integralLogMapper.checkIntegralValidity(logDO);
        if (Objects.nonNull(po)) {
            log.info("channel integral [{}] is invalidity", JsonUtil.toString(po));
            throw new HWJYCheckException(ResultEnum.INTEGRAL_COLLECT_IS_INVALIDITY);
        }
    }
}
