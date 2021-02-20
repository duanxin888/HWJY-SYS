package com.duanxin.hwjy.infrastructure.client.counter;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * @author duanxin
 * @version 1.0
 * @className RedisCounterClient
 * @date 2021/02/10 09:49
 */
@Service
@AllArgsConstructor
@Slf4j
public class RedisCounterClient implements CounterClient {

    private final StringRedisTemplate redisTemplate;

    @Override
    public Optional<Long> counter(String key) {
        try {
            Long increment = redisTemplate.boundValueOps(key).increment();
            if (Objects.isNull(increment)) {
                return Optional.empty();
            }
            return Optional.of(increment);
        } catch (Exception exception) {
            log.warn("fetch [{}] counter exception", key, exception);
            return Optional.empty();
        }
    }

    @Override
    public void reset(String key) {
        redisTemplate.delete(key);
    }
}
