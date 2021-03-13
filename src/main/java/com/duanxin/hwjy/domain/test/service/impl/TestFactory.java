package com.duanxin.hwjy.domain.test.service.impl;

import com.duanxin.hwjy.domain.test.entity.TestDO;
import com.duanxin.hwjy.domain.test.entity.valueobject.TestType;
import com.duanxin.hwjy.infrastructure.client.test.TestResponseDto;
import com.duanxin.hwjy.infrastructure.client.test.TxGarbageSortingType;
import com.duanxin.hwjy.infrastructure.repository.po.TestPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author duanxin
 * @version 1.0
 * @className TestFactory
 * @date 2021/03/13 09:30
 */
@Component
public class TestFactory {

    public TestDO responseDto2DO(TestResponseDto dto) {
        TestDO testDO = new TestDO();
        testDO.setTestQuestion(dto.getName());
        testDO.setTestResult(TxGarbageSortingType.fetchNameByType(dto.getType()));
        testDO.setTestOptions(dto.getTestOptions());
        testDO.setTestType(TestType.fetchByCode(dto.getTestType()));
        return testDO;
    }

    public TestPO do2PO(TestDO testDO) {
        TestPO po = new TestPO();
        BeanUtils.copyProperties(testDO, po);
        po.setTestType(testDO.getTestType().getCode());
        po.setTestSource(testDO.getTestSource().getCode());
        return po;
    }
}
