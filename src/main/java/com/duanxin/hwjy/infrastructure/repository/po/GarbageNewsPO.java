package com.duanxin.hwjy.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className GarbageNewsPO
 * @date 2021/02/08 10:06
 */
@Setter
@Getter
public class GarbageNewsPO {

    private int id;

    private String newsTitle;

    private String newsDetails;

    private String picUrl;

    private String newsUrl;

    private String newsCtime;

    private int sourceType;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
