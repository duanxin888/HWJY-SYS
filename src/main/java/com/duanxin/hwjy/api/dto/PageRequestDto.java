package com.duanxin.hwjy.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className PageRequestDto
 * @date 2021/02/26 16:07
 */
@Getter
@Setter
public class PageRequestDto {

    private int pageSize;

    private int pageNum;
}
