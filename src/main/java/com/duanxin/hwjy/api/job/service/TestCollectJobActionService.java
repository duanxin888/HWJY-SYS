package com.duanxin.hwjy.api.job.service;

import com.duanxin.hwjy.api.job.TestCollectJob;
import com.duanxin.hwjy.infrastructure.common.constants.LockKeyConstants;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author duanxin
 * @version 1.0
 * @className TestCollectJobActionService
 * @date 2021/03/13 10:05
 */
@Service
public class TestCollectJobActionService extends AbsJobActionService {

    private final TestCollectJob testCollectJob;

    public TestCollectJobActionService(TestCollectJob testCollectJob) {
        super(JobActionType.TEST_COLLECT, testCollectJob::collectTest,
                Collections.singleton(LockKeyConstants.TEST_COLLECT_JOB_KEY.getKey()));
        this.testCollectJob = testCollectJob;
    }
}
