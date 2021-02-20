package com.duanxin.hwjy.domain.news.repository;

import com.duanxin.hwjy.domain.news.entity.GarbageNewsDO;

/**
 * @author duanxin
 * @version 1.0
 * @className GarbageNewsRepository
 * @date 2021/02/09 10:21
 */
public interface GarbageNewsRepository {

    void insert(GarbageNewsDO garbageNewsDO);
}
