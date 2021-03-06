package com.duanxin.hwjy.domain.news.repository.impl;

import com.duanxin.hwjy.domain.news.entity.GarbageNewsDO;
import com.duanxin.hwjy.domain.news.repository.GarbageNewsRepository;
import com.duanxin.hwjy.domain.news.service.impl.GarbageNewsFactory;
import com.duanxin.hwjy.infrastructure.repository.mapper.GarbageNewsMapper;
import com.duanxin.hwjy.infrastructure.repository.po.GarbageNewsPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className GarbageNewsRepositoryImpl
 * @date 2021/02/09 10:22
 */
@Repository
@Slf4j
@AllArgsConstructor
public class GarbageNewsRepositoryImpl implements GarbageNewsRepository {

    private final GarbageNewsMapper garbageNewsMapper;
    private final GarbageNewsFactory garbageNewsFactory;

    @Override
    public void insert(GarbageNewsDO garbageNewsDO) {
        GarbageNewsPO po = garbageNewsFactory.do2PO(garbageNewsDO);
        garbageNewsMapper.insert(po);
        log.info("success to insert garbageNewsDO [{}]", JsonUtil.toString(po));
    }

    @Override
    public boolean isExisted(GarbageNewsDO garbageNewsDO) {
        return Objects.nonNull(garbageNewsMapper.selectByNewsTitle(garbageNewsDO.getNewsTitle()));
    }

    @Override
    public List<GarbageNewsDO> getGarbageNews(int pageNum, int pageSize) {
        List<GarbageNewsPO> pos = garbageNewsMapper.selectGarbageNewsWithPage((pageNum * pageSize) + 1, pageSize);
        return pos.stream().map(garbageNewsFactory::po2DO).collect(Collectors.toList());
    }
}
