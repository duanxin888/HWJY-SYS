package com.duanxin.hwjy.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryPO
 * @date 2021/02/27 11:07
 */
@Setter
@Getter
public class DictionaryPO {

    private int id;

    private String dictionarySn;

    private String dictionaryStatus;

    private String dictionaryName;

    private String dictionaryItem;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
