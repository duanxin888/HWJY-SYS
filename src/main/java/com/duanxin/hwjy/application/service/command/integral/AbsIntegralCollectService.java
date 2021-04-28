package com.duanxin.hwjy.application.service.command.integral;

import com.duanxin.hwjy.domain.system.service.DictionaryDomainService;
import com.duanxin.hwjy.domain.user.entity.IntegralLogDO;
import com.duanxin.hwjy.domain.user.entity.valueobject.IntegralOperateChannel;
import com.duanxin.hwjy.domain.user.service.IntegralDomainService;
import com.duanxin.hwjy.domain.user.service.UserDomainService;
import com.duanxin.hwjy.infrastructure.client.counter.CounterClient;
import com.duanxin.hwjy.infrastructure.common.constants.DictionaryConstants;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className AbsIntegralCollectService
 * @date 2021/04/28 15:09
 */
@Slf4j
public abstract class AbsIntegralCollectService {

    @Autowired
    private UserDomainService userDomainService;
    @Autowired
    private IntegralDomainService integralDomainService;
    @Autowired
    private DictionaryDomainService dictionaryDomainService;
    @Autowired
    private CounterClient counterClient;

    @Getter
    private final IntegralOperateChannel[] isSupport;

    public AbsIntegralCollectService(IntegralOperateChannel... isSupport) {
        this.isSupport = isSupport;
    }

    public BigDecimal collectIntegral(IntegralLogDO logDO) {
        // check
        check(logDO);
        // fetch integral number
        BigDecimal integralNumber = Objects.isNull(logDO.getIntegralNumber()) ?
                fetchIntegralNumber(logDO.getIntegralOperateChannel().name()) : logDO.getIntegralNumber();
        // do collect integral
        return doCollectIntegral(logDO, integralNumber);
    }

    private BigDecimal doCollectIntegral(IntegralLogDO logDO, BigDecimal integralNumber) {
        return integralDomainService.collectIntegral(logDO, integralNumber);
    }

    private void check(IntegralLogDO logDO) {
        // check integral channel is validity
        checkIntegralValidity(logDO);
        // check user & account exist
        checkValidity(logDO.getUserId(), logDO.getIntegralAccountSn());
        // check points collection limit
        checkCollectLimit(logDO);
    }

    private BigDecimal fetchIntegralNumber(String itemValue) {
        String dictionaryValue =
                dictionaryDomainService.getItemValue(DictionaryConstants.INTEGRAL_DICTIONARY.name(), itemValue);
        return BigDecimal.valueOf(Double.parseDouble(dictionaryValue));
    }

    private void checkIntegralValidity(IntegralLogDO logDO) {
        integralDomainService.checkIntegralValidity(logDO);
    }

    private void checkValidity(int userId, String integralAccountSn) {
        userDomainService.selectById(userId);
        integralDomainService.selectBySn(integralAccountSn);
    }

    protected void checkCollectLimit(IntegralLogDO logDO) {
        IntegralOperateChannel integralOperateChannel = logDO.getIntegralOperateChannel();
        if (counterClient.counter(integralOperateChannel + "_COUNTER").
                orElseThrow(() -> new HWJYCheckException(ResultEnum.INTEGRAL_COLLECT_IS_INVALIDITY)) >
                fetchCollectLimit(integralOperateChannel.name())) {
            log.info("integral [{}] collect reaches the upper limit", JsonUtil.toString(logDO));
            throw new HWJYCheckException(ResultEnum.INTEGRAL_COLLECT_REACHES_THE_UPPER_LIMIT);
        }
    }

    private Long fetchCollectLimit(String itemValue) {
        String dictionaryValue =
                dictionaryDomainService.getItemValue(DictionaryConstants.INTEGRAL_COLLECT_LIMIT.name(), itemValue);
        return Long.parseLong(dictionaryValue);
    }
}
