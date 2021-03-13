package com.duanxin.hwjy.application.service.command;

import com.duanxin.hwjy.domain.test.service.TestDomainService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className TestAppService
 * @date 2021/03/05 21:15
 */
@Service
@AllArgsConstructor
public class TestAppService {

    private final TestDomainService testDomainService;

    public void collectTest() {
        testDomainService.collectTest();
    }
}
