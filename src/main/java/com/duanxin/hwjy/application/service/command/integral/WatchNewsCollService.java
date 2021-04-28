package com.duanxin.hwjy.application.service.command.integral;

import com.duanxin.hwjy.domain.user.entity.valueobject.IntegralOperateChannel;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className WatchNewsCollService
 * @date 2021/04/28 15:33
 */
@Service
public class WatchNewsCollService extends AbsIntegralCollectService{

    public WatchNewsCollService() {
        super(IntegralOperateChannel.COLLECTION_BY_WATCH_NEWS);
    }
}
