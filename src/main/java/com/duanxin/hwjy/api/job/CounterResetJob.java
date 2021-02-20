package com.duanxin.hwjy.api.job;

import com.duanxin.hwjy.infrastructure.client.counter.CounterClient;
import com.duanxin.hwjy.infrastructure.client.lock.LockClient;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import com.duanxin.hwjy.infrastructure.common.constants.CounterConstants;
import com.duanxin.hwjy.infrastructure.common.constants.LockKeyConstants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @author duanxin
 * @version 1.0
 * @className CounterResetJob
 * @date 2021/02/20 09:12
 */
@Component
@Slf4j
@AllArgsConstructor
public class CounterResetJob {

    private final CounterClient counterClient;
    private final LockClient lockClient;

    @Scheduled(cron = "0 0 0 * * ? *")
    public void counterReset() {
        log.info("begin to execute CounterResetJob");
        for (CounterConstants value : CounterConstants.values()) {
            String key = LockKeyConstants.COUNTER_RESET_JOB_KEY.getKey()
                    + Constants.CACHE_SEP.getDesc() + value.name();
            if (!lockClient.lock(key, Duration.ofMinutes(30))) {
                log.info("failed to fetch lock [{}]", key);
                continue;
            }
            counterClient.reset(value.name());
        }
    }
}