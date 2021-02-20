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
}
