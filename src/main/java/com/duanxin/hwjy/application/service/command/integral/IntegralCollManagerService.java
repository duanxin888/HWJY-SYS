package com.duanxin.hwjy.application.service.command.integral;

import com.duanxin.hwjy.domain.user.entity.IntegralLogDO;
import com.duanxin.hwjy.domain.user.entity.valueobject.IntegralOperateChannel;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralCollManagerService
 * @date 2021/04/28 15:35
 */
@Service
public class IntegralCollManagerService {

    private final List<AbsIntegralCollectService> integralCollectServices;
    private Map<IntegralOperateChannel, AbsIntegralCollectService> integralCollectServiceMap;

    public IntegralCollManagerService(List<AbsIntegralCollectService> integralCollectServices) {
        this.integralCollectServices = integralCollectServices;
        init();
    }

    private void init() {
        Map<IntegralOperateChannel, AbsIntegralCollectService> map = new HashMap<>(IntegralOperateChannel.values().length);
        integralCollectServices.forEach(s -> Arrays.stream(s.getIsSupport()).forEach(support -> map.put(support, s)));
        this.integralCollectServiceMap = Collections.unmodifiableMap(map);
    }

    public BigDecimal collectIntegral(IntegralOperateChannel channel, IntegralLogDO logDO) {
        AbsIntegralCollectService service = integralCollectServiceMap.get(channel);
        if (Objects.isNull(service)) {
            throw new HWJYCheckException(ResultEnum.INTEGRAL_COLLECT_SERVICE_NOT_SUPPORT);
        }
        return service.collectIntegral(logDO);
    }
}
