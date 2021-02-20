package com.duanxin.hwjy.application.service.command;

import com.duanxin.hwjy.domain.news.service.GarbageNewsDomainService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className GarbageNewsAppService
 * @date 2021/02/09 10:08
 */
@Service
@Slf4j
@AllArgsConstructor
public class GarbageNewsAppService {

    private final GarbageNewsDomainService garbageNewsDomainService;

    public void collectNews() {
        garbageNewsDomainService.collectNews();
    }
}
