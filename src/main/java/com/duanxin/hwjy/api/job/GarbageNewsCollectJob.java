package com.duanxin.hwjy.api.job;

import com.duanxin.hwjy.application.service.command.GarbageNewsAppService;
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
 * @className GarbageNewsCollectJob
 * @date 2021/02/08 10:36
 */
@Component
@AllArgsConstructor
@Slf4j
public class GarbageNewsCollectJob {

    private final LockClient lockClient;
    private final GarbageNewsAppService garbageNewsAppService;

    @Scheduled(cron = "${job.garbageNewsCollect.time}")
    public void collectNews() {
        log.info("begin to execute GarbageNewsCollectJob");
        if (!lockClient.lock(LockKeyConstants.GARBAGE_NEWS_COLLECT_JOB_KEY.getKey(),
                Duration.ofMinutes(30))) {
            log.info("failed to fetch lock [{}]", LockKeyConstants.GARBAGE_NEWS_COLLECT_JOB_KEY.getKey());
            return ;
        }
        garbageNewsAppService.collectNews();
        log.info("success to execute GarbageNewsCollectJob");
    }
}
