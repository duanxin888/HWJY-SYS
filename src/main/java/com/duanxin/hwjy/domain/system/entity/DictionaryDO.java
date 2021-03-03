package com.duanxin.hwjy.domain.system.entity;

import com.duanxin.hwjy.domain.system.entity.valueobject.DictionaryItem;
import com.duanxin.hwjy.domain.system.entity.valueobject.DictionaryStatus;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryDO
 * @date 2021/02/27 11:12
 */
@Setter
@Getter
public class DictionaryDO {

    private int id;

    private String dictionarySn;

    private DictionaryStatus dictionaryStatus = DictionaryStatus.AVAILABLE;

    private String dictionaryName;

    private List<DictionaryItem> dictionaryItems;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();

    public void create(String dictionarySn) {
        this.setDictionarySn(dictionarySn);
        this.setDictionaryItems(new ArrayList<>());
    }

    public DictionaryItem fetchItemByName(String itemName) {
        return this.getDictionaryItems().stream().filter(f -> f.getName().equals(itemName)).
                findFirst().orElseThrow(() -> new HWJYCheckException(ResultEnum.DICTIONARY_ITEM_NOT_EXIST));
    }
}
