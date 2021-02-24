package com.duanxin.hwjy.api.job.service;

import com.duanxin.hwjy.infrastructure.client.lock.LockClient;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author duanxin
 * @version 1.0
 * @className AbsJobActionService
 * @date 2021/02/21 09:08
 */
public abstract class AbsJobActionService {

    @Getter
    private final JobActionType isSupported;
    private final Runnable action;
    private final Set<String> lockKeys;

    @Autowired
    private LockClient lockClient;

    public AbsJobActionService(JobActionType isSupported, Runnable action, Set<String> lockKeys) {
        this.isSupported = isSupported;
        this.action = action;
        this.lockKeys = lockKeys;
    }

    public void jobAction() {
        releaseLock();
        action.run();
    }

    protected void releaseLock() {
        lockKeys.forEach(lockClient::releaseLock);
    }
}
