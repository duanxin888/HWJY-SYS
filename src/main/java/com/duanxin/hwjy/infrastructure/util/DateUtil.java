package com.duanxin.hwjy.infrastructure.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author duanxin
 * @version 1.0
 * @className DateUtil
 * @date 2021/01/14 15:13
 */
public class DateUtil {

    private DateUtil() {

    }

    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime();
    }
}
