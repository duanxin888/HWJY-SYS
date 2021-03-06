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

    USER_NOT_LOG_IN(400, "user not log in"),
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
    USER_DEFAULT_ADDRESS_NOT_EXIST(406, "user default address not exist"),


    JOB_ACTION_NOT_SUPPORT_SERVICE(407, "job action not support service"),

    DICTIONARY_NOT_EXIST(408, "dictionary not exist"),
    DICTIONARY_ITEM_NOT_EXIST(408, "dictionary item not exist"),

    INTEGRAL_COLLECT_IS_INVALIDITY(410, "积分收集失败"),
    INTEGRAL_COLLECT_REACHES_THE_UPPER_LIMIT(410, "积分收集达到上线"),

    TEST_COLLECT_BY_THIRD_PARTY_ERROR_CODE(411, "test collect by third party error code"),

    MATCH_IMAGE_FILE_FAILED(412, "match image file failed"),
    ASSEMBLER_FILE2DTO_FAILED(412, "assembler file2dto failed"),

    PRODUCT_IS_EXIST_BY_NAME(413, "product is exist by name"),
    PRODUCT_NOT_EXIST(413, "product not exist"),
    PRODUCT_ATTRIBUTE_NOT_EXIST(413, "product attribute not exist"),
    PRODUCT_SPECIFICATION_NOT_EXIST(413, "product specification not exist"),
    PRODUCT_STOCK_NOT_EXIST(413, "product stock not exist"),
    PRODUCT_IS_OFF_SALE(413, "product is off sale"),
    PRODUCT_CATEGORY_IS_EXIST(413, "product category is exist"),

    CART_OPERATE_TYPE_CODE_ERROR(414, "cart operate type code error"),
    CART_STATUS_CODE_NOT_EXIST(414, "cart status code not exist"),
    USER_VALID_CART_NOT_EXIST(414, "user valid cart not exist"),
    USER_CART_PRODUCT_TRANS_ERROR(414, "user cart product trans error"),
    USER_ORDER_STATUS_NOT_EXIST(414, "user order status not exist"),
    USER_ORDER_IS_DELETED(414, "user order is deleted"),
    USER_ORDER_NOT_DELETE(414, "user order not delete"),

    INTEGRAL_COLLECT_SERVICE_NOT_SUPPORT(415, "integral collect service not support");

    private final int code;
    private final String desc;
}
