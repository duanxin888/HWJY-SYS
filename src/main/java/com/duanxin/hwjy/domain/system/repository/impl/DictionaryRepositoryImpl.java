package com.duanxin.hwjy.domain.system.repository.impl;

import com.duanxin.hwjy.domain.system.entity.DictionaryDO;
import com.duanxin.hwjy.domain.system.repository.DictionaryRepository;
import com.duanxin.hwjy.domain.system.service.impl.DictionaryFactory;
import com.duanxin.hwjy.infrastructure.repository.mapper.DictionaryMapper;
import com.duanxin.hwjy.infrastructure.repository.po.DictionaryPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryRepositoryImpl
 * @date 2021/03/01 10:37
 */
@Repository
@AllArgsConstructor
@Slf4j
public class DictionaryRepositoryImpl implements DictionaryRepository {

    private final DictionaryMapper dictionaryMapper;
    private final DictionaryFactory dictionaryFactory;

    @Override
    public DictionaryDO addDictionary(DictionaryDO dictionaryDO) {
        DictionaryPO po = dictionaryFactory.do2PO(dictionaryDO);
        dictionaryMapper.insert(po);
        log.info("success to insert dictionary [{}]", JsonUtil.toString(po));
        dictionaryDO.setId(po.getId());
        return dictionaryDO;
    }
}
