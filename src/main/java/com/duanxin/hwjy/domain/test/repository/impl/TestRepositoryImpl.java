package com.duanxin.hwjy.domain.test.repository.impl;

import com.duanxin.hwjy.domain.test.entity.TestDO;
import com.duanxin.hwjy.domain.test.repository.TestRepository;
import com.duanxin.hwjy.domain.test.service.impl.TestFactory;
import com.duanxin.hwjy.infrastructure.repository.mapper.TestMapper;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author duanxin
 * @version 1.0
 * @className TestRepositoryImpl
 * @date 2021/03/13 09:23
 */
@Repository
@AllArgsConstructor
@Slf4j
public class TestRepositoryImpl implements TestRepository {

    private final TestMapper testMapper;
    private final TestFactory testFactory;

    @Override
    public void insert(TestDO testDO) {
        testMapper.insert(testFactory.do2PO(testDO));
        log.info("success to insert test [{}]", JsonUtil.toString(testDO));
    }
}
