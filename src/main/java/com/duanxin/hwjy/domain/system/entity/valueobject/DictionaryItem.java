package com.duanxin.hwjy.domain.system.entity.valueobject;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryItem
 * @date 2021/02/27 11:12
 */
@Setter
@Getter
public class DictionaryItem {

    private String dictionarySn;

    private int sorted;

    private String name;

    private String value;
}
