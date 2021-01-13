package com.duanxin.hwjy.infrastructure.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className ResultEnum
 * @date 2021/01/08 19:02
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {

    USER_NOT_LOG_IN(403, "user not log in"),


    WX_MA_NOT_CONFIG(500, "WeChat configuration is not equipped"),
    APPID_NOT_MATCH_WX_SERVICE(401, "appid not match wx service"),
    REQUEST_WX_CODE2SESSION_API_FAIL(401, "failed to request wx code2session api");

    private final int code;
    private final String desc;
}
