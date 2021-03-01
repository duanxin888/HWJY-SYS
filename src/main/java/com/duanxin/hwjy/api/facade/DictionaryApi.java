package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.api.assembler.DictionaryAssembler;
import com.duanxin.hwjy.api.dto.dictionary.DictionaryAddCommandDto;
import com.duanxin.hwjy.application.service.command.DictionaryAppService;
import com.duanxin.hwjy.domain.system.entity.DictionaryDO;
import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryApi
 * @date 2021/02/27 14:51
 */
@RestController
@RequestMapping("/api/v1/dictionary")
@AllArgsConstructor
public class DictionaryApi {

    private final DictionaryAppService dictionaryAppService;

    @PostMapping
    public ResponseResult addDictionary(@RequestBody DictionaryAddCommandDto dictionaryAddCommandDto) {
        DictionaryDO dictionaryDO = dictionaryAppService.addDictionary(DictionaryAssembler.addCommand2DO(dictionaryAddCommandDto));
        return ResponseResult.success(DictionaryAssembler.do2QueryResponseDto(dictionaryDO));
    }
}
