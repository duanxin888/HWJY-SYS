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
    USER_IS_NOT_AVAILABLE(403, "user is not available"),
    USER_IS_NOT_EXIST(403, "user is not exist"),
    INTEGRAL_ACCOUNT_IS_NOT_AVAILABLE(403, "integral account is not available"),
    VERIFY_USER_LOGGED_IN_EXCEPTION(403, "verify user is logged in exception"),


    WX_MA_NOT_CONFIG(500, "WeChat configuration is not equipped"),
    APPID_NOT_MATCH_WX_SERVICE(401, "appid not match wx service"),
    REQUEST_WX_CODE2SESSION_API_FAIL(401, "failed to request wx code2session api"),

    NO_SUPPORT_SN_GENERATOR(404, "no support sn generator"),

    REDIS_CACHE_KEY_IS_BLANK(405, "redis cache key is blank"),

    USER_ADDRESS_UPDATE_ACQUIESCENCE_FAILED(406, "user address update acquiescence failed"),
    USER_ADDRESS_UPDATE_FAILED(406, "user address update failed"),


    JOB_ACTION_NOT_SUPPORT_SERVICE(407, "job action not support service"),

    DICTIONARY_NOT_EXIST(408, "dictionary not exist"),
    DICTIONARY_ITEM_NOT_EXIST(408, "dictionary item not exist"),

    INTEGRAL_COLLECT_IS_INVALIDITY(410, "integral collect is invalidity");

    private final int code;
    private final String desc;
}
