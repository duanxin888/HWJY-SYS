package com.duanxin.hwjy.api.job.service;

import com.duanxin.hwjy.api.job.OrderJob;
import com.duanxin.hwjy.infrastructure.common.constants.LockKeyConstants;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderCancelJobActionService
 * @date 2021/04/22 09:50
 */
@Service
public class OrderJobActionService extends AbsJobActionService{

    private final OrderJob orderJob;

    public OrderJobActionService(OrderJob orderJob) {
        super(JobActionType.ORDER_CANCEL, orderJob::cancelOrder,
                Collections.singleton(LockKeyConstants.ORDER_CANCEL_JOB_KEY.getKey()));
        this.orderJob = orderJob;
    }
}
