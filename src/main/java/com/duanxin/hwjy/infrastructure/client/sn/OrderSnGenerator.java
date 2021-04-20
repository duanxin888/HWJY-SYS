package com.duanxin.hwjy.infrastructure.client.sn;

import com.duanxin.hwjy.infrastructure.common.enums.SnType;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderSnGenerator
 * @date 2021/04/20 10:59
 */
@Component
public class OrderSnGenerator extends AbsSnGenerator{

    private final static AtomicInteger STEPPER = new AtomicInteger(1);

    public OrderSnGenerator() {
        super(SnType.ORDER_SN_TYPE);
    }

    /**
     * order sn: type(2) + year(2) + month(2) + day(2) +
     *          hour(2) + minute(2) + second(3) + STEPPER(11)
     *
     * */
    @Override
    public String generate() {
        NumberFormat format = NumberFormat.getInstance();
        LocalDateTime now = LocalDateTime.now();
        return new StringBuilder(getSupportType().getTypeId()).
                append(numberFormat(format, 4, now.getYear())).
                append(numberFormat(format, 2, now.getMonthValue())).
                append(numberFormat(format, 2, now.getDayOfMonth())).
                append(numberFormat(format, 2, now.getHour())).
                append(numberFormat(format, 2, now.getMinute())).
                append(numberFormat(format, 3, now.getSecond())).
                append(numberFormat(format, 11, STEPPER.getAndIncrement())).
                toString();
    }
}
