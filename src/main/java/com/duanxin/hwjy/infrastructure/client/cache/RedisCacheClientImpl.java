package com.duanxin.hwjy.infrastructure.client.cache;

import com.duanxin.hwjy.infrastructure.common.enums.Constants;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * @author duanxin
 * @version 1.0
 * @className RedisClientImpl
 * @date 2021/01/21 10:00
 */
@Service
@Slf4j
@AllArgsConstructor
public class RedisCacheClientImpl implements CacheClient {

    private final StringRedisTemplate redisTemplate;

    @Override
    public void refreshCache(String key, Object value, Duration ttl, String... args) {
        key = generateKey(key, args);
        if (StringUtils.isBlank(key)) {
            log.warn("redis cache key [{}] is blank", key);
            throw new HWJYCheckException(ResultEnum.REDIS_CACHE_KEY_IS_BLANK);
        }
        try {
            redisTemplate.boundValueOps(key).setIfAbsent(JsonUtil.toString(value), ttl);
        } catch (Exception exception) {
            log.warn("refresh cache [{}] exception", key, exception);
        }
    }

    private String generateKey(String key, String... args) {
        if (StringUtils.isAllBlank(args)) {
            return key;
        }
        return key +
                Constants.CACHE_SEP.getDesc() +
                StringUtils.join(args, Constants.CACHE_SEP.getDesc());
    }
}
