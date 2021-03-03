package com.duanxin.hwjy.domain.system.service;

import com.duanxin.hwjy.domain.system.entity.DictionaryDO;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryDomainService
 * @date 2021/03/01 10:36
 */
public interface DictionaryDomainService {

    DictionaryDO addDictionary(DictionaryDO dictionaryDO);

    void updateItem(DictionaryDO dictionaryDO);

    String getItemValue(String dictionaryName, String itemName);
}
