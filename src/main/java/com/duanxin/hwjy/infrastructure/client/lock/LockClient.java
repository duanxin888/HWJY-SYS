package com.duanxin.hwjy.infrastructure.client.lock;

import java.time.Duration;

/**
 * @author duanxin
 * @version 1.0
 * @className LockClient
 * @date 2021/02/20 09:22
 */
public interface LockClient {

    /**
     * lock of key
     * @param key lock name
     * @param ttl expire date
     * @date 2021/2/20 20:26
     * @return boolean
     */
    boolean lock(String key, Duration ttl);

    /**
     * lock of key
     * @param key lock name
     * @param ttl expire date(unit: s)
     * @date 2021/2/20 20:27
     * @return boolean
     */
    boolean lock(String key, long ttl);

    /**
     * release lock of key
     * @param key lock name
     * @date 2021/2/20 20:28
     * @return boolean
     */
    boolean releaseLock(String key);
}
