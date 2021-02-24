package com.duanxin.hwjy.api.job.service;

import com.duanxin.hwjy.api.job.GarbageNewsCollectJob;
import com.duanxin.hwjy.infrastructure.common.constants.LockKeyConstants;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author duanxin
 * @version 1.0
 * @className GarbageNewsCollectJobActionService
 * @date 2021/02/21 10:47
 */
@Service
public class GarbageNewsCollectJobActionService extends AbsJobActionService{

    private final GarbageNewsCollectJob garbageNewsCollectJob;

    public GarbageNewsCollectJobActionService(GarbageNewsCollectJob garbageNewsCollectJob) {
        super(JobActionType.GARBAGE_NEWS_COLLECT, garbageNewsCollectJob::collectNews,
                Collections.singleton(LockKeyConstants.GARBAGE_NEWS_COLLECT_JOB_KEY.getKey()));
        this.garbageNewsCollectJob = garbageNewsCollectJob;
    }
}
