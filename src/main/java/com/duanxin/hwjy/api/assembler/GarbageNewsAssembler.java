package com.duanxin.hwjy.api.assembler;

import com.duanxin.hwjy.api.dto.news.GarbageNewsQueryResponseDto;
import com.duanxin.hwjy.domain.news.entity.GarbageNewsDO;
import org.springframework.beans.BeanUtils;

/**
 * @author duanxin
 * @version 1.0
 * @className GarbageNewsAssembler
 * @date 2021/02/26 16:15
 */
public class GarbageNewsAssembler {

    private GarbageNewsAssembler() {
    }

    public static GarbageNewsQueryResponseDto do2QueryResponseDto(GarbageNewsDO garbageNewsDO) {
        GarbageNewsQueryResponseDto dto = new GarbageNewsQueryResponseDto();
        BeanUtils.copyProperties(garbageNewsDO, dto);
        return dto;
    }
}
