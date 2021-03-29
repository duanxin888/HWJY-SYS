package com.duanxin.hwjy.infrastructure.common.constants;

import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;

/**
 * @author duanxin
 * @version 1.0
 * @className ImageFileSufConstants
 * @date 2021/03/29 09:12
 */
public enum ImageFileSufConstants {

    PNG, JPG, JPEG;

    public static boolean matchSufName(String sufName) {
        for (ImageFileSufConstants value : values()) {
            if (value.name().equalsIgnoreCase(sufName)) {
                return true;
            }
        }
        throw new HWJYCheckException(ResultEnum.MATCH_IMAGE_FILE_FAILED);
    }
}
