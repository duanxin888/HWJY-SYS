package com.duanxin.hwjy.infrastructure.configuration;

import com.duanxin.hwjy.infrastructure.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author duanxin
 * @version 1.0
 * @className WebConfiguration
 * @date 2021/01/25 08:44
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).
                excludePathPatterns("/api/v1/users/login").
                excludePathPatterns("/api/v1/users/tokens/refresh").
                excludePathPatterns("/api/v1/admin/job/**");
    }
}
