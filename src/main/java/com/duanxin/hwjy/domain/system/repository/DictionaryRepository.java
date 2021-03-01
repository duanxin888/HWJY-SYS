package com.duanxin.hwjy.domain.system.repository;

import com.duanxin.hwjy.domain.system.entity.DictionaryDO;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryRepository
 * @date 2021/03/01 10:37
 */
public interface DictionaryRepository {

    DictionaryDO addDictionary(DictionaryDO dictionaryDO);
}
