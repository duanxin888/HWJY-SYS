package com.duanxin.hwjy.domain.user.event;

import com.duanxin.hwjy.domain.user.entity.IntegralAccountDO;
import com.duanxin.hwjy.domain.user.entity.UserDO;
import com.duanxin.hwjy.domain.user.repository.UserRepository;
import com.duanxin.hwjy.domain.user.service.IntegralDomainService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author duanxin
 * @version 1.0
 * @className PointsConsumptionListener
 * @date 2021/04/22 14:25
 */
@Component
@Slf4j
@AllArgsConstructor
public class PointsConsumptionListener {

    private final IntegralDomainService integralDomainService;
    private final TransactionTemplate transactionTemplate;
    private final UserRepository userRepository;

    @EventListener(Consumption4OrderEvent.class)
    @Async("consumptionIntegralExecutor")
    public void consumption4Order(Consumption4OrderEvent event) {
        IntegralAccountDO accountDO = integralDomainService.selectBySn(event.getIntegralAccountSn());
        UserDO userDO = userRepository.selectByIntegralAccountSn(accountDO.getIntegralAccountSn());
        transactionTemplate.execute((status) -> {
            // reduce integral
            integralDomainService.consumptionIntegral(accountDO, event.getIntegralNumber());
            // append log
            integralDomainService.appendConsumptionLog(accountDO, event.getIntegralNumber(),
                    event.getSource(), userDO.getId());
            return Boolean.TRUE;
        });
    }
}
