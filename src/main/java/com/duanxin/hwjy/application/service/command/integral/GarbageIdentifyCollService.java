package com.duanxin.hwjy.application.service.command.integral;

import com.duanxin.hwjy.domain.user.entity.valueobject.IntegralOperateChannel;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className GarbageIdentifyCollService
 * @date 2021/04/28 15:30
 */
@Service
public class GarbageIdentifyCollService extends AbsIntegralCollectService{

    public GarbageIdentifyCollService() {
        super(IntegralOperateChannel.COLLECTION_BY_GARBAGE_IDENTIFICATION_WITH_TEXT,
                IntegralOperateChannel.COLLECTION_BY_GARBAGE_IDENTIFICATION_WITH_PICTURES,
                IntegralOperateChannel.COLLECTION_BY_GARBAGE_IDENTIFICATION_WITH_LANGUAGE);
    }
}
