package com.duanxin.hwjy.domain.user.service.impl.factory;

import com.duanxin.hwjy.domain.user.entity.IntegralLogDO;
import com.duanxin.hwjy.infrastructure.repository.po.IntegralLogPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralFactory
 * @date 2021/03/02 11:28
 */
@Component
public class IntegralFactory {

    public IntegralLogPO createIntegralLogPO(IntegralLogDO logDO) {
        IntegralLogPO po = new IntegralLogPO();
        BeanUtils.copyProperties(logDO, po);
        po.setOperateType(logDO.getOperateType().name());
        po.setIntegralOperateChannel(logDO.getIntegralOperateChannel().name());
        return po;
    }
}
