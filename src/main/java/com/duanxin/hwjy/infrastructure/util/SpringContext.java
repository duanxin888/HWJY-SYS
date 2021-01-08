package com.duanxin.hwjy.infrastructure.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author duanxin
 * @version 1.0
 * @className SpringContext
 * @date 2020/10/10 21:32
 */
@Component
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T getBean(String name, Class<T> cls) {
        return context.getBean(name, cls);
    }

    public static <T> T getBean(Class<T> cls) {
        return context.getBean(cls);
    }
}
