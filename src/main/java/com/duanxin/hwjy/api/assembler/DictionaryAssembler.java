package com.duanxin.hwjy.api.assembler;

import com.duanxin.hwjy.api.dto.dictionary.DictionaryAddCommandDto;
import com.duanxin.hwjy.api.dto.dictionary.DictionaryItemCommandDto;
import com.duanxin.hwjy.api.dto.dictionary.DictionaryQueryResponseDto;
import com.duanxin.hwjy.domain.system.entity.DictionaryDO;
import org.springframework.beans.BeanUtils;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryAssembler
 * @date 2021/02/27 21:12
 */
public class DictionaryAssembler {

    private DictionaryAssembler() {
    }

    public static DictionaryDO addCommand2DO(DictionaryAddCommandDto dto) {
        DictionaryDO dictionaryDO = new DictionaryDO();
        BeanUtils.copyProperties(dto, dictionaryDO);
        return dictionaryDO;
    }

    public static DictionaryQueryResponseDto do2QueryResponseDto(DictionaryDO dictionaryDO) {
        DictionaryQueryResponseDto dto = new DictionaryQueryResponseDto();
        BeanUtils.copyProperties(dictionaryDO, dto);
        dto.setDictionaryStatus(dictionaryDO.getDictionaryStatus().name());
        return dto;
    }

    public static DictionaryDO itemCommand2DO(DictionaryItemCommandDto dto) {
        DictionaryDO dictionaryDO = new DictionaryDO();
        BeanUtils.copyProperties(dto, dictionaryDO);
        return dictionaryDO;
    }
}
