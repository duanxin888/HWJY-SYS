package com.duanxin.hwjy.application.service.query;

import com.duanxin.hwjy.domain.news.entity.GarbageNewsDO;
import com.duanxin.hwjy.domain.news.repository.GarbageNewsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className GarbageNewsQueryAppService
 * @date 2021/02/26 16:11
 */
@Service
@AllArgsConstructor
@Slf4j
public class GarbageNewsQueryAppService {

    private final GarbageNewsRepository garbageNewsRepository;

    public List<GarbageNewsDO> getGarbageNews(int pageNum, int pageSize) {
        return garbageNewsRepository.getGarbageNews(pageNum, pageSize);
    }
}
