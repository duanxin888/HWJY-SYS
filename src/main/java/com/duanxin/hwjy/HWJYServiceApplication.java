package com.duanxin.hwjy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author duanxin
 * @version 1.0
 * @className HWJYServiceApplication
 * @date 2021/01/08 18:28
 */
@SpringBootApplication
@MapperScan(basePackages = "com.duanxin.hwjy.infrastructure.repository.mapper")
@EnableScheduling
public class HWJYServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HWJYServiceApplication.class, args);
    }
}
