package com.duanxin.hwjy.infrastructure.client.sn;

import com.duanxin.hwjy.infrastructure.common.enums.SnType;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Integral account serial number generator
 * version(2) + year(4) + month(2) + day(2) + hour(2) + minute(2) + second(2) +
 * stepper(11) + randomizer(8)
 *
 * @author duanxin
 * @version 1.0
 * @className IntegralAccountSnGenerator
 * @date 2021/01/14 10:30
 */
@Component
public class IntegralAccountSnGenerator extends AbsSnGenerator {

    private static final AtomicInteger STEPPER = new AtomicInteger(0);

    public IntegralAccountSnGenerator() {
        super(SnType.INTEGRAL_ACCOUNT_SN_TYPE);
    }

    /**
     * integral account sn:
     *      year(4) + month(2) + day(2) + hour(2) + minute(2) + second(2)
     *      + STEPPER(11) + randomizer(8)
     * */
    @Override
    public String generate() {
        LocalDateTime now = LocalDateTime.now();
        NumberFormat format = NumberFormat.getInstance();
        return new StringBuilder(this.getSupportType().getTypeId()).
                append(numberFormat(format, 4, now.getYear())).
                append(numberFormat(format, 2, now.getMonthValue())).
                append(numberFormat(format, 2, now.getDayOfMonth())).
                append(numberFormat(format, 2, now.getHour())).
                append(numberFormat(format, 2, now.getMinute())).
                append(numberFormat(format, 2, now.getSecond())).
                append(numberFormat(format, 11, STEPPER.getAndIncrement())).
                append(generateRandomAlphameric(8)).
                toString();
    }
}
