package com.duanxin.hwjy.domain.test.repository;

import com.duanxin.hwjy.domain.test.entity.TestDO;

/**
 * @author duanxin
 * @version 1.0
 * @className TestRepository
 * @date 2021/03/13 09:22
 */
public interface TestRepository {

    void insert(TestDO testDO);

    boolean isExisted(TestDO testDO);
}
