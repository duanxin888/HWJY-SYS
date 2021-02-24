package com.duanxin.hwjy.api.job.service;

import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className JobActionManagerService
 * @date 2021/02/21 10:48
 */
@Service
@Slf4j
public class JobActionManagerService {

    private final List<AbsJobActionService> jobActionServices;
    private Map<JobActionType, AbsJobActionService> jobActionServiceMap;

    public JobActionManagerService(List<AbsJobActionService> jobActionServices) {
        this.jobActionServices = jobActionServices;
        init();
    }

    private void init() {
        Map<JobActionType, AbsJobActionService> serviceMap = jobActionServices.stream().
                collect(Collectors.toMap(AbsJobActionService::getIsSupported, s -> s));
        jobActionServiceMap = Collections.unmodifiableMap(serviceMap);
    }

    public void jobAction(JobActionType jobActionType) {
        AbsJobActionService actionService = jobActionServiceMap.get(jobActionType);
        if (Objects.isNull(actionService)) {
            log.warn("[{}] job action service not support", jobActionType);
            throw new HWJYCheckException(ResultEnum.JOB_ACTION_NOT_SUPPORT_SERVICE);
        }
        actionService.jobAction();
    }
}
