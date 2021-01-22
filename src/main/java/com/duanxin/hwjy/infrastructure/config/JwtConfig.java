package com.duanxin.hwjy.infrastructure.config;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className JwtConfig
 * @date 2021/01/22 10:14
 */
@Setter
@Getter
public class JwtConfig {

    private String header;

    private String tokenHead;

    private long expireTime;
}
