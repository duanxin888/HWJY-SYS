package com.duanxin.hwjy.infrastructure.client.news;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className NewsRequestDto
 * @date 2021/02/09 09:01
 */
@Setter
@Getter
public class NewsRequestDto {

    private int num;

    private int page;

    private String word;
}
