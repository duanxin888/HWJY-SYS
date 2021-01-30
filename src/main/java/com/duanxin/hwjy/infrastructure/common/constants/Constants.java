package com.duanxin.hwjy.infrastructure.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author duanxin
 * @version 1.0
 * @className Constants
 * @date 2021/01/10 09:49
 */
@Getter
@AllArgsConstructor
public enum Constants {

    CREATOR("SYSTEM"), EDITOR("SYSTEM"), CACHE_SEP(":"), REQUEST_ID("requestId");

    private final String desc;
}
