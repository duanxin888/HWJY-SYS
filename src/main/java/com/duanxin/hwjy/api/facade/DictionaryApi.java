package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.api.assembler.DictionaryAssembler;
import com.duanxin.hwjy.api.dto.dictionary.DictionaryAddCommandDto;
import com.duanxin.hwjy.api.dto.dictionary.DictionaryItemCommandDto;
import com.duanxin.hwjy.application.service.command.DictionaryAppService;
import com.duanxin.hwjy.application.service.query.DictionaryQueryAppService;
import com.duanxin.hwjy.domain.system.entity.DictionaryDO;
import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryApi
 * @date 2021/02/27 14:51
 */
@RestController
@RequestMapping("/api/v1/dictionary")
@AllArgsConstructor
@Validated
public class DictionaryApi {

    private final DictionaryAppService dictionaryAppService;
    private final DictionaryQueryAppService dictionaryQueryAppService;

    @PostMapping
    public ResponseResult addDictionary(@RequestBody @Valid DictionaryAddCommandDto dictionaryAddCommandDto) {
        DictionaryDO dictionaryDO = dictionaryAppService.addDictionary(DictionaryAssembler.addCommand2DO(dictionaryAddCommandDto));
        return ResponseResult.success(DictionaryAssembler.do2QueryResponseDto(dictionaryDO));
    }

    @PutMapping("/item")
    public ResponseResult updateItem(@RequestBody @Valid DictionaryItemCommandDto dto) {
        dictionaryAppService.updateItem(DictionaryAssembler.itemCommand2DO(dto));
        return ResponseResult.success();
    }

    @GetMapping
    public ResponseResult getDictionary() {
        List<DictionaryDO> dos = dictionaryQueryAppService.getDictionary();
        return ResponseResult.success(dos.stream().
                map(DictionaryAssembler::do2QueryResponseDto).
                collect(Collectors.toList()));
    }
}
