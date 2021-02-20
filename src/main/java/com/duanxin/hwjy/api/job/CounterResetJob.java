package com.duanxin.hwjy.api.job;

import com.duanxin.hwjy.infrastructure.client.counter.CounterClient;
import com.duanxin.hwjy.infrastructure.common.constants.CounterConstants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

    @Scheduled(cron = "0 0 0 * * ? *")
    public void counterReset() {
        for (CounterConstants value : CounterConstants.values()) {
            counterClient.reset(value.name());
        }
    }
}