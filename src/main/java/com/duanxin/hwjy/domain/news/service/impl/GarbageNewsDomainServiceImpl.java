package com.duanxin.hwjy.domain.news.service.impl;

import com.duanxin.hwjy.domain.news.repository.GarbageNewsRepository;
import com.duanxin.hwjy.domain.news.service.GarbageNewsDomainService;
import com.duanxin.hwjy.infrastructure.client.counter.CounterClient;
import com.duanxin.hwjy.infrastructure.client.news.NewsRequestClient;
import com.duanxin.hwjy.infrastructure.client.news.NewsRequestDto;
import com.duanxin.hwjy.infrastructure.client.news.NewsResponseDto;
import com.duanxin.hwjy.infrastructure.common.constants.CounterConstants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author duanxin
 * @version 1.0
 * @className GarbageNewsDomainServiceImpl
 * @date 2021/02/09 10:20
 */
@Service
@Slf4j
@AllArgsConstructor
public class GarbageNewsDomainServiceImpl implements GarbageNewsDomainService {

    private final GarbageNewsRepository garbageNewsRepository;
    private final NewsRequestClient newsRequestClient;
    private final GarbageNewsFactory garbageNewsFactory;
    private final CounterClient counterClient;

    @Override
    public void collectNews() {
        // assembly request param
        NewsRequestDto requestDto = assemblyRequestParam(timedLoopCounter());
        // request client
        Optional<List<NewsResponseDto>> optional = newsRequestClient.fetchNews(requestDto);
        if (!optional.isPresent()) {
            return ;
        }
        // storage data
        optional.get().stream().map(garbageNewsFactory::responseDto2DO).forEach(garbageNewsRepository::insert);
    }

    private NewsRequestDto assemblyRequestParam(int count) {
        NewsRequestDto dto = new NewsRequestDto();
        dto.setPage(count);
        dto.setNum(50);
        return dto;
    }

    /**
     * function: Execute this method once and the counter is incremented by one
     * */
    private int timedLoopCounter() {
        return counterClient.counter(CounterConstants.GARBAGE_NEWS_COUNTER.name()).
                orElse(0L).intValue();
    }
}
