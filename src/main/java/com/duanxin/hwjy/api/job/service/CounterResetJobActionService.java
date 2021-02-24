package com.duanxin.hwjy.api.job.service;

import com.duanxin.hwjy.api.job.CounterResetJob;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import com.duanxin.hwjy.infrastructure.common.constants.CounterConstants;
import com.duanxin.hwjy.infrastructure.common.constants.LockKeyConstants;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author duanxin
 * @version 1.0
 * @className CounterResetJobActionService
 * @date 2021/02/21 09:12
 */
@Service
public class CounterResetJobActionService extends AbsJobActionService{

    private final CounterResetJob counterResetJob;

    public CounterResetJobActionService(CounterResetJob counterResetJob) {
        super(JobActionType.COUNTER_RESET, counterResetJob::counterReset, buildKeys());
        this.counterResetJob = counterResetJob;
    }

    private static Set<String> buildKeys() {
        Set<String> keys = new HashSet<>();
        for (CounterConstants key : CounterConstants.values()) {
            keys.add(LockKeyConstants.COUNTER_RESET_JOB_KEY.getKey()
                    + Constants.CACHE_SEP.getDesc() + key.name());
        }
        return keys;
    }
}
