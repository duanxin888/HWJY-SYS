package com.duanxin.hwjy.application.service.command.integral;

import com.duanxin.hwjy.domain.user.entity.IntegralLogDO;
import com.duanxin.hwjy.domain.user.entity.valueobject.IntegralOperateChannel;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className DoTestCollService
 * @date 2021/04/28 15:34
 */
@Service
public class DoTestCollService extends AbsIntegralCollectService{

    public DoTestCollService() {
        super(IntegralOperateChannel.COLLECTION_BY_DO_TEST);
    }

    @Override
    protected void checkCollectLimit(IntegralLogDO logDO) {
        // do nothing
    }
}
