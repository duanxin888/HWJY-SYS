package com.duanxin.hwjy.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className TestPO
 * @date 2021/03/13 09:09
 */
@Setter
@Getter
public class TestPO {

    private int id;

    private int testType;

    private String testQuestion;

    private String testOptions;

    private String testResult;

    private int testSource;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
