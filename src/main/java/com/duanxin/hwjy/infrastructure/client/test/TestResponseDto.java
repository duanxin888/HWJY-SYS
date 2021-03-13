package com.duanxin.hwjy.infrastructure.client.test;

import com.duanxin.hwjy.infrastructure.common.constants.TestConstants;
import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className TestResponseDto
 * @date 2021/03/04 21:18
 */
@Setter
@Getter
public class TestResponseDto {

    private String name;

    private int type;

    private String explain;

    private int testType = 0;

    private String testOptions = TestConstants.SIMPLE_CHOICE_TEST_OPTIONS;
}
