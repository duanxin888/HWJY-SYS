package com.duanxin.hwjy.api.dto.dictionary;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryAddCommandDto
 * @date 2021/02/27 20:45
 */
@Getter
@Setter
public class DictionaryAddCommandDto {

    @NotBlank(message = "dictionaryName NotBlank")
    private String dictionaryName;
}
