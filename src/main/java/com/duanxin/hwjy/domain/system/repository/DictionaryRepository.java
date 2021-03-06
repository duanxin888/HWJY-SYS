package com.duanxin.hwjy.domain.system.repository;

import com.duanxin.hwjy.domain.system.entity.DictionaryDO;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryRepository
 * @date 2021/03/01 10:37
 */
public interface DictionaryRepository {

    DictionaryDO addDictionary(DictionaryDO dictionaryDO);

    DictionaryDO selectBySn(String dictionarySn);

    void updateItem(DictionaryDO dictionaryDO);

    List<DictionaryDO> getDictionary();

    DictionaryDO selectByName(String dictionaryName);
}
