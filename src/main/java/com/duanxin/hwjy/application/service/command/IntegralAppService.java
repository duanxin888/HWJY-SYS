package com.duanxin.hwjy.application.service.command;

import com.duanxin.hwjy.application.service.command.integral.IntegralCollManagerService;
import com.duanxin.hwjy.domain.user.entity.IntegralLogDO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralAppService
 * @date 2021/03/02 10:24
 */
@Service
@AllArgsConstructor
@Slf4j
public class IntegralAppService {

    private final IntegralCollManagerService integralCollManagerService;

    public BigDecimal collectIntegral(IntegralLogDO logDO) {
        return integralCollManagerService.collectIntegral(logDO.getIntegralOperateChannel(), logDO);
    }
}
