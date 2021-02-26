package com.duanxin.hwjy.domain.news.service.impl;

import com.duanxin.hwjy.domain.news.entity.GarbageNewsDO;
import com.duanxin.hwjy.domain.news.entity.valueobject.NewsSourceType;
import com.duanxin.hwjy.infrastructure.client.news.NewsResponseDto;
import com.duanxin.hwjy.infrastructure.repository.po.GarbageNewsPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author duanxin
 * @version 1.0
 * @className GarbageNewsFactory
 * @date 2021/02/10 09:31
 */
@Component
public class GarbageNewsFactory {

    public GarbageNewsDO responseDto2DO(NewsResponseDto dto) {
        GarbageNewsDO garbageNewsDO = new GarbageNewsDO();
        garbageNewsDO.setNewsTitle(dto.getTitle());
        garbageNewsDO.setNewsDetails(dto.getDescription());
        garbageNewsDO.setNewsUrl(dto.getUrl());
        garbageNewsDO.setNewsCtime(dto.getCtime());
        garbageNewsDO.setPicUrl(dto.getPicUrl());
        return garbageNewsDO;
    }

    public GarbageNewsPO do2PO(GarbageNewsDO garbageNewsDO) {
        GarbageNewsPO po = new GarbageNewsPO();
        BeanUtils.copyProperties(garbageNewsDO, po);
        po.setSourceType(garbageNewsDO.getSourceType().getCode());
        return po;
    }

    public GarbageNewsDO po2DO(GarbageNewsPO po) {
        GarbageNewsDO garbageNewsDO = new GarbageNewsDO();
        BeanUtils.copyProperties(po, garbageNewsDO);
        garbageNewsDO.setSourceType(NewsSourceType.formatByCode(po.getSourceType()));
        return garbageNewsDO;
    }
}
