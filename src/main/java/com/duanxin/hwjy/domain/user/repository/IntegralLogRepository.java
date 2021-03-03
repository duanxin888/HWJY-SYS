package com.duanxin.hwjy.domain.user.repository;

import com.duanxin.hwjy.domain.user.entity.IntegralLogDO;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralLogRepository
 * @date 2021/03/02 11:23
 */
public interface IntegralLogRepository {
    void insert(IntegralLogDO logDO);

    void checkIntegralValidity(IntegralLogDO logDO);
}
