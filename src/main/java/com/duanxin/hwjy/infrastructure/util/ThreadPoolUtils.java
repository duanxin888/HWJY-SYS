package com.duanxin.hwjy.infrastructure.util;

import com.duanxin.hwjy.infrastructure.config.ThreadPoolConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author duanxin
 * @version 1.0
 * @className ThreadPoolUtils
 * @date 2020/11/01 15:24
 */
@Slf4j
public class ThreadPoolUtils {

    private ThreadPoolUtils() {

    }

    public static ThreadPoolExecutor threadPoolExecutor(ThreadPoolConfig config) {
        return new ThreadPoolExecutor(config.getCorePoolSize(),
                config.getMaximumPoolSize(),
                config.getKeepAliveTime(),
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(config.getWorkQueueSize()),
                r -> new Thread("threadPool-" + config.getThreadPoolName()),
                (execute, r) -> log.info("[{}] thread pool is full and can`t receive tasks", config.getThreadPoolName()));
    }
}
