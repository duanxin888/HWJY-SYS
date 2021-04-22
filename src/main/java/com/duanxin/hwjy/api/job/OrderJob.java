package com.duanxin.hwjy.api.job;

import com.duanxin.hwjy.application.service.command.OrderAppService;
import com.duanxin.hwjy.infrastructure.client.lock.LockClient;
import com.duanxin.hwjy.infrastructure.common.constants.LockKeyConstants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderJob
 * @date 2021/04/22 08:54
 */
@Component
@Slf4j
@AllArgsConstructor
public class OrderJob {

    private final LockClient lockClient;
    private final OrderAppService orderAppService;

    //@Scheduled(cron = "${job.cancelOrder.time}")
    public void cancelOrder() {
        log.info("begin to execute cancelOrder job");
        if (!lockClient.lock(LockKeyConstants.ORDER_CANCEL_JOB_KEY.getKey(),
                Duration.ofMinutes(15))) {
            log.info("failed to fetch key [{}]", LockKeyConstants.ORDER_CANCEL_JOB_KEY);
            return ;
        }
        orderAppService.cancelOrder();
        log.info("success to execute cancelOrder job");
    }
}
