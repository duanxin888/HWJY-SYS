package com.duanxin.hwjy.infrastructure.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;

/**
 * @author duanxin
 * @version 1.0
 * @className CacheTypeEnum
 * @date 2021/01/11 08:25
 */
@Getter
@AllArgsConstructor
public enum CacheTypeEnum {

    DEFAULT(Duration.ofDays(1L), "DEFAULT");

    private final Duration ttl;
    private final String prefix;
}
