package com.duanxin.hwjy.domain.news.entity;

import com.duanxin.hwjy.domain.news.entity.valueobject.NewsSourceType;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className GarbageNewsDO
 * @date 2021/02/08 10:12
 */
@Setter
@Getter
public class GarbageNewsDO {

    private int id;

    private String newsTitle;

    private String newsDetails;

    private String picUrl;

    private String newsUrl;

    private String newsCtime;

    private NewsSourceType sourceType = NewsSourceType.THIRD_PARTY;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();
}
