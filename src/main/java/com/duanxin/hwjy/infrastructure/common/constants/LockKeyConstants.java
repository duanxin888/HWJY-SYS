package com.duanxin.hwjy.infrastructure.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className LockKeyConstants
 * @date 2021/02/20 20:37
 */
@AllArgsConstructor
@Getter
public enum LockKeyConstants {

    COUNTER_RESET_JOB_KEY("JOB_KEY:COUNTER_RESET"),
    GARBAGE_NEWS_COLLECT_JOB_KEY("JOB_KEY:GARBAGE_NEWS_COLLECT"),
    TEST_COLLECT_JOB_KEY("JOB_KEY:TEST_COLLECT"),
    ORDER_CANCEL_JOB_KEY("JOB_KEY:ORDER_CANCEL");

    private final String key;
}
