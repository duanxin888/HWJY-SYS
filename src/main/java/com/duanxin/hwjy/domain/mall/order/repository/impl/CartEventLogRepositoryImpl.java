package com.duanxin.hwjy.domain.mall.order.repository.impl;

import com.duanxin.hwjy.domain.mall.order.entity.CartEventLogDO;
import com.duanxin.hwjy.domain.mall.order.repository.CartEventLogRepository;
import com.duanxin.hwjy.domain.mall.order.service.impl.CartEventLogFactory;
import com.duanxin.hwjy.infrastructure.repository.mapper.CartEventLogMapper;
import com.duanxin.hwjy.infrastructure.repository.po.CartEventLogPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author duanxin
 * @version 1.0
 * @className CartEventLogRepositoryImpl
 * @date 2021/04/11 10:50
 */
@Repository
@AllArgsConstructor
@Slf4j
public class CartEventLogRepositoryImpl implements CartEventLogRepository {

    private final CartEventLogMapper cartEventLogMapper;
    private final CartEventLogFactory cartEventLogFactory;

    @Override
    public void appendLog(CartEventLogDO eventLogDO) {
        CartEventLogPO po = cartEventLogFactory.do2PO(eventLogDO);
        cartEventLogMapper.insert(po);
        log.info("success to insert CartEventLog [{}]", JsonUtil.toString(po));
    }
}
