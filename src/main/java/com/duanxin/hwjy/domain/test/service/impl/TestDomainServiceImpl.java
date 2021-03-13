package com.duanxin.hwjy.domain.test.service.impl;

import com.duanxin.hwjy.domain.test.repository.TestRepository;
import com.duanxin.hwjy.domain.test.service.TestDomainService;
import com.duanxin.hwjy.infrastructure.client.test.TestRequestClient;
import com.duanxin.hwjy.infrastructure.client.test.TestResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author duanxin
 * @version 1.0
 * @className TestDomainServiceImpl
 * @date 2021/03/13 09:23
 */
@Service
@AllArgsConstructor
@Slf4j
public class TestDomainServiceImpl implements TestDomainService {

    private final TestRepository testRepository;
    private final TestRequestClient testRequestClient;
    private final TestFactory testFactory;

    @Override
    public void collectTest() {
        Optional<List<TestResponseDto>> optional = testRequestClient.fetchTest();
        if (!optional.isPresent()) {
            return ;
        }
        optional.get().stream().map(testFactory::responseDto2DO).
                filter(f -> !testRepository.isExisted(f)).forEach(testRepository::insert);
    }
}
