package com.duanxin.hwjy.infrastructure.configuration;

import com.duanxin.hwjy.infrastructure.config.JwtConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author duanxin
 * @version 1.0
 * @className JwtConfiguration
 * @date 2021/01/22 10:15
 */
@Configuration
public class JwtConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "jwt")
    public JwtConfig jwtConfig() {
        return new JwtConfig();
    }
}
