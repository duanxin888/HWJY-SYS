package com.duanxin.hwjy.infrastructure.client.lock;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author duanxin
 * @version 1.0
 * @className RedisLockClient
 * @date 2021/02/20 20:28
 */
@Service
@Slf4j
@AllArgsConstructor
public class RedisLockClient implements LockClient{

    private final StringRedisTemplate redisTemplate;

    @Override
    public boolean lock(String key, Duration ttl) {
        try {
            return redisTemplate.boundValueOps(key).setIfAbsent(key, ttl);
        } catch (Exception exception) {
            log.warn("lock key [{}] exception", key, exception);
            return false;
        }
    }

    @Override
    public boolean lock(String key, long ttl) {
        try {
            return redisTemplate.boundValueOps(key).setIfAbsent(key, ttl, TimeUnit.SECONDS);
        } catch (Exception exception) {
            log.warn("lock key [{}] exception", key, exception);
            return false;
        }
    }

    @Override
    public boolean releaseLock(String key) {
        try {
            return redisTemplate.delete(key);
        } catch (Exception exception) {
            log.warn("release lock [{}] exception", key, exception);
            return false;
        }
    }
}
