package com.duanxin.hwjy.infrastructure.client.sn;

import com.duanxin.hwjy.infrastructure.common.enums.SnType;
import lombok.Getter;

import java.text.NumberFormat;
import java.util.Random;

/**
 * @author duanxin
 * @version 1.0
 * @className AbsSnGenerator
 * @date 2021/01/14 10:48
 */
public abstract class AbsSnGenerator implements SnGenerator {

    @Getter
    private final SnType supportType;

    public AbsSnGenerator(SnType supportType) {
        this.supportType = supportType;
    }

    protected String numberFormat(NumberFormat format, int size, int num) {
        format.setGroupingUsed(false);
        format.setMinimumIntegerDigits(size);
        format.setMaximumIntegerDigits(size);
        return format.format(num);
    }

    protected String generateRandomAlphameric(int length) {
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit= randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase= randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase= randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit|| isUppercase || isLowercase) {
                randomChars[count] = (char) (randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }
}
