package com.duanxin.hwjy.infrastructure.client.sn;

import com.duanxin.hwjy.infrastructure.common.enums.SnType;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionarySnGenerator
 * @date 2021/03/01 20:24
 */
@Component
public class DictionarySnGenerator extends AbsSnGenerator{

    public DictionarySnGenerator() {
        super(SnType.DICTIONARY_SN_TYPE);
    }

    /**
     * dictionary sn:
     *      year(4) + month(2) + day(2) + hour(2) + minute(2) + second(2) + randomizer(8)
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
                append(numberFormat(format, 2, now.getSecond())).
                append(generateRandomAlphameric(8)).toString();
    }
}
