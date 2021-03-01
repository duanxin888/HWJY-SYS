package com.duanxin.hwjy.api.dto.dictionary;

import com.duanxin.hwjy.domain.system.entity.valueobject.DictionaryItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryQueryResponseDto
 * @date 2021/03/01 20:39
 */
@Setter
@Getter
public class DictionaryQueryResponseDto {

    private int id;

    private String dictionarySn;

    private String dictionaryStatus;

    private String dictionaryName;

    private List<DictionaryItem> dictionaryItems;
}
