package com.duanxin.hwjy.infrastructure.configuration;

import com.duanxin.hwjy.infrastructure.config.ThreadPoolConfig;
import com.duanxin.hwjy.infrastructure.util.ThreadPoolUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author duanxin
 * @version 1.0
 * @className ThreadPoolConfiguration
 * @date 2021/04/22 09:15
 */
@Configuration
public class ThreadPoolConfiguration {

    @Bean("cancelOrderThreadPool")
    @ConfigurationProperties(prefix = "thread.order.cancel")
    public ThreadPoolConfig cancelOrderThreadPool() {
        return new ThreadPoolConfig();
    }

    @Bean("cancelOrderThreadPoolExecutor")
    public ThreadPoolExecutor cancelOrderExecutor(@Qualifier("cancelOrderThreadPool") ThreadPoolConfig config) {
        return ThreadPoolUtils.threadPoolExecutor(config);
    }
}
