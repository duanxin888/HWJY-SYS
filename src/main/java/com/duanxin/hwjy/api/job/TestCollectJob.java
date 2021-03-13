package com.duanxin.hwjy.api.job;

import com.duanxin.hwjy.application.service.command.TestAppService;
import com.duanxin.hwjy.infrastructure.client.lock.LockClient;
import com.duanxin.hwjy.infrastructure.common.constants.LockKeyConstants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @author duanxin
 * @version 1.0
 * @className TestCollectJob
 * @date 2021/03/05 20:50
 */
@Component
@Slf4j
@AllArgsConstructor
public class TestCollectJob {

    private final LockClient lockClient;
    private final TestAppService testAppService;

    @Scheduled(cron = "${job.testCollect.time}")
    public void collectTest() {
        log.info("begin to execute TestCollectJob");
        if (!lockClient.lock(LockKeyConstants.TEST_COLLECT_JOB_KEY.getKey(),
                Duration.ofMinutes(5))) {
            log.info("failed to fetch lock [{}]", LockKeyConstants.TEST_COLLECT_JOB_KEY.getKey());
            return ;
        }
        testAppService.collectTest();
        log.info("success to execute TestCollectJob");
    }
}
