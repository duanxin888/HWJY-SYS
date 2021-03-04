package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.api.assembler.GarbageNewsAssembler;
import com.duanxin.hwjy.application.service.query.GarbageNewsQueryAppService;
import com.duanxin.hwjy.domain.news.entity.GarbageNewsDO;
import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className GarbageNewsApi
 * @date 2021/02/08 10:33
 */
@RestController
@Validated
@RequestMapping("/api/v1/news")
@AllArgsConstructor
public class GarbageNewsApi {

    private final GarbageNewsQueryAppService garbageNewsQueryAppService;

    @GetMapping
    public ResponseResult getGarbageNews(int pageNum, int pageSize) {
        List<GarbageNewsDO> dos = garbageNewsQueryAppService.getGarbageNews(pageNum, pageSize);
        return ResponseResult.success(dos.stream().
                map(GarbageNewsAssembler::do2QueryResponseDto).
                collect(Collectors.toList()));
    }
}
