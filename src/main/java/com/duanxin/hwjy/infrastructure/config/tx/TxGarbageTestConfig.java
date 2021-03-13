package com.duanxin.hwjy.infrastructure.config.tx;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className TxGarbageTestConfig
 * @date 2021/03/04 21:14
 */
@Setter
@Getter
public class TxGarbageTestConfig {

    private TxBaseConfig baseConfig;

    private String resource;

    public TxGarbageTestConfig(TxBaseConfig baseConfig) {
        this.baseConfig = baseConfig;
    }
}
