package com.duanxin.hwjy.application.service.command;

import com.duanxin.hwjy.domain.system.service.DictionaryDomainService;
import com.duanxin.hwjy.domain.user.entity.IntegralLogDO;
import com.duanxin.hwjy.domain.user.service.IntegralDomainService;
import com.duanxin.hwjy.domain.user.service.UserDomainService;
import com.duanxin.hwjy.infrastructure.common.constants.DictionaryConstants;
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

    private final UserDomainService userDomainService;
    private final IntegralDomainService integralDomainService;
    private final DictionaryDomainService dictionaryDomainService;

    public void collectIntegral(IntegralLogDO logDO) {
        // check user & account exist
        checkValidity(logDO.getUserId(), logDO.getIntegralAccountSn());
        // check integral channel is validity
        checkIntegralValidity(logDO);
        // fetch integral number
        BigDecimal integralNumber = fetchIntegralNumber(logDO.getIntegralOperateChannel().name());
        // update account & append log
        integralDomainService.collectIntegral(logDO, integralNumber);
    }

    private void checkIntegralValidity(IntegralLogDO logDO) {
        integralDomainService.checkIntegralValidity(logDO);
    }

    private BigDecimal fetchIntegralNumber(String itemValue) {
        String dictionaryValue =
                dictionaryDomainService.getItemValue(DictionaryConstants.INTEGRAL_DICTIONARY.name(), itemValue);
        return BigDecimal.valueOf(Double.parseDouble(dictionaryValue));
    }

    private void checkValidity(int userId, String integralAccountSn) {
        userDomainService.selectById(userId);
        integralDomainService.selectBySn(integralAccountSn);
    }
}
