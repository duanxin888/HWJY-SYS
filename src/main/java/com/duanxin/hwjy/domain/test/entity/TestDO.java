package com.duanxin.hwjy.domain.test.entity;

import com.duanxin.hwjy.domain.test.entity.valueobject.TestSourceType;
import com.duanxin.hwjy.domain.test.entity.valueobject.TestType;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className TestDO
 * @date 2021/03/13 09:14
 */
@Setter
@Getter
public class TestDO {

    private int id;

    private TestType testType;

    private String testQuestion;

    private String testOptions;

    private String testResult;

    private TestSourceType testSource = TestSourceType.THIRD_PARTY;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();
}
