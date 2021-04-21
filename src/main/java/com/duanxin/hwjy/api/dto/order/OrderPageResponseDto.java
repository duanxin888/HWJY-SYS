package com.duanxin.hwjy.api.dto.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderPageResponseDto
 * @date 2021/04/21 18:24
 */
@Setter
@Getter
public class OrderPageResponseDto {

    private int pageNum;

    private int pageSize;

    private int pages;

    private List<OrderListResponseDto> orders;
}
