package com.duanxin.hwjy.infrastructure.client.news;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className NewsResponseDto
 * @date 2021/02/09 08:58
 */
@Setter
@Getter
public class NewsResponseDto {

    private String id;

    private String title;

    private String description;

    private String picUrl;

    private String url;

    private String ctime;

    private String source;
}
