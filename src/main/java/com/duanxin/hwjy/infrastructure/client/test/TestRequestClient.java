package com.duanxin.hwjy.infrastructure.client.test;

import java.util.List;
import java.util.Optional;

/**
 * @author duanxin
 * @version 1.0
 * @className TestRequestClient
 * @date 2021/03/04 21:18
 */
public interface TestRequestClient {

    Optional<List<TestResponseDto>> fetchTest();
}
