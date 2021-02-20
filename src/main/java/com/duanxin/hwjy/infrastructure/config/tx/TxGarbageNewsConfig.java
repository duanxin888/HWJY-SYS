package com.duanxin.hwjy.infrastructure.config.tx;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className TxGarbageNewsConfig
 * @date 2021/02/09 09:06
 */
@Setter
@Getter
public class TxGarbageNewsConfig {

    private TxBaseConfig txBaseConfig;

    private String resource;

    public TxGarbageNewsConfig(TxBaseConfig txBaseConfig) {
        this.txBaseConfig = txBaseConfig;
    }
}
