package com.duanxin.hwjy.domain.user.event;

import com.duanxin.hwjy.infrastructure.common.event.DomainEvent;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className Comsuption4OrderEvent
 * @date 2021/04/22 14:26
 */
@Setter
@Getter
public class Consumption4OrderEvent extends DomainEvent {

    private String integralAccountSn;

    private BigDecimal integralNumber;
}
