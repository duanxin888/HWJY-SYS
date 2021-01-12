package com.duanxin.hwjy.infrastructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className WxMaConfig
 * @date 2021/01/12 08:43
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "wx.miniapp")
public class WxMaConfig {

    private List<Config> configs;

    @Setter
    @Getter
    public static class Config {

        private String appid;

        private String secret;

        private String token;

        private String aesKey;

        private String msgDataFormat;
    }
}
