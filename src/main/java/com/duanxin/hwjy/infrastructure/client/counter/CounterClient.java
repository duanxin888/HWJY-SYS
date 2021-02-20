package com.duanxin.hwjy.infrastructure.client.counter;

import java.util.Optional;

/**
 * client of counter
 * method: counter, reset
 * @author duanxin
 * @version 1.0
 * @className CounterClient
 * @date 2021/02/10 09:48
 */
public interface CounterClient {

    Optional<Long> counter(String key);

    void reset(String key);
}
