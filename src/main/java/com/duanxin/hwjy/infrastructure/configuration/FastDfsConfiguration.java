package com.duanxin.hwjy.infrastructure.configuration;

import com.duanxin.hwjy.infrastructure.config.FastDfsConfig;
import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author duanxin
 * @version 1.0
 * @className FastDfsConfiguration
 * @date 2021/03/20 09:15
 */
@Configuration
@Import(FdfsClientConfig.class)
public class FastDfsConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "fdfs")
    public FastDfsConfig fastDfsConfig() {
        return new FastDfsConfig();
    }
}
