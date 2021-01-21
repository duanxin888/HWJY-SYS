package com.duanxin.hwjy.infrastructure.client.redis;

import java.time.Duration;

/**
 * @author duanxin
 * @version 1.0
 * @className RedisClient
 * @date 2021/01/21 09:59
 */
public interface RedisCacheClient {

    void refreshCache(String key, Object value, Duration ttl, String... args);
}
