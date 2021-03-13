package com.duanxin.hwjy.infrastructure.configuration;

import com.duanxin.hwjy.infrastructure.config.RestClientConfig;
import com.duanxin.hwjy.infrastructure.config.tx.TxBaseConfig;
import com.duanxin.hwjy.infrastructure.config.tx.TxGarbageNewsConfig;
import com.duanxin.hwjy.infrastructure.config.tx.TxGarbageTestConfig;
import com.duanxin.hwjy.infrastructure.util.RestClientUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * client of tianXing(link: https://www.tianapi.com/)
 * @author duanxin
 * @version 1.0
 * @className RestRequestConfiguration
 * @date 2021/02/08 20:04
 */
@Configuration
public class TxClientConfiguration {

    @Bean("txRestClientConfig")
    @ConfigurationProperties(prefix = "tx.request")
    public RestClientConfig txRestClientConfig() {
        return new RestClientConfig();
    }

    @Bean("txRestTemplate")
    public RestTemplate txRestTemplate(@Qualifier("txRestClientConfig") RestClientConfig config) {
        return RestClientUtil.restTemplate(config);
    }

    @Bean
    @ConfigurationProperties(prefix = "tx.api")
    public TxBaseConfig txBaseConfig() {
        return new TxBaseConfig();
    }

    @Bean
    @ConfigurationProperties(prefix = "tx.api.news.garbage")
    public TxGarbageNewsConfig txGarbageNewsConfig(TxBaseConfig baseConfig) {
        return new TxGarbageNewsConfig(baseConfig);
    }

    @Bean
    @ConfigurationProperties(prefix = "tx.api.test.garbage")
    public TxGarbageTestConfig txGarbageTestConfig(TxBaseConfig baseConfig) {
        return new TxGarbageTestConfig(baseConfig);
    }
}
