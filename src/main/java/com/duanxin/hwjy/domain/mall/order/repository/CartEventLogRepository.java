package com.duanxin.hwjy.domain.mall.order.repository;

import com.duanxin.hwjy.domain.mall.order.entity.CartEventLogDO;

/**
 * @author duanxin
 * @version 1.0
 * @className CartEventLogRepository
 * @date 2021/04/11 10:50
 */
public interface CartEventLogRepository {

    void appendLog(CartEventLogDO eventLogDO);
}
