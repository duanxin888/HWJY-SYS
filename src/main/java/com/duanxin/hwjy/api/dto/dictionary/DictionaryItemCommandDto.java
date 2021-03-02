package com.duanxin.hwjy.api.dto.dictionary;

import com.duanxin.hwjy.domain.system.entity.valueobject.DictionaryItem;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryItemCommandDto
 * @date 2021/03/02 09:25
 */
@Setter
@Getter
public class DictionaryItemCommandDto {

    @NotBlank(message = "dictionarySn NotBlank")
    private String dictionarySn;

    @NotBlank(message = "dictionaryName NotBlank")
    private String dictionaryName;

    @NotNull(message = "dictionaryItems NotNull")
    private List<DictionaryItem> dictionaryItems;
}
