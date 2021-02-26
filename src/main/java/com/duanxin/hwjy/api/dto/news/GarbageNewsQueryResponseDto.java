package com.duanxin.hwjy.api.dto.news;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className GarbageNewsQueryResponseDto
 * @date 2021/02/26 16:12
 */
@Setter
@Getter
public class GarbageNewsQueryResponseDto {

    private int id;

    private String newsTitle;

    private String newsDetails;

    private String picUrl;

    private String newsUrl;

    private String newsCtime;
}
