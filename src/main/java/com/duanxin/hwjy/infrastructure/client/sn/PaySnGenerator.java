package com.duanxin.hwjy.infrastructure.client.sn;

import com.duanxin.hwjy.infrastructure.common.enums.SnType;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author duanxin
 * @version 1.0
 * @className PaySnGenerator
 * @date 2021/04/22 16:40
 */
@Component
public class PaySnGenerator extends AbsSnGenerator{

    public PaySnGenerator() {
        super(SnType.PAY_SN);
    }

    /**
     * pay sn: type(2) + year(4) + month(2) + day(2) + hour(2) + minute(2) +
     *      second(3) + random num(3)
     *
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
                append(numberFormat(format, 3, now.getSecond())).
                append(numberFormat(format, 3, new Random(1).nextInt(100))).
                toString();
    }
}
