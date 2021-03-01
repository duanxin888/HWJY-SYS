package com.duanxin.hwjy.domain.system.service.impl;

import com.duanxin.hwjy.domain.system.entity.DictionaryDO;
import com.duanxin.hwjy.domain.system.repository.DictionaryRepository;
import com.duanxin.hwjy.domain.system.service.DictionaryDomainService;
import com.duanxin.hwjy.infrastructure.client.sn.SnGenerateManagerService;
import com.duanxin.hwjy.infrastructure.common.enums.SnType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryDomainServiceImpl
 * @date 2021/03/01 10:36
 */
@Service
@Slf4j
@AllArgsConstructor
public class DictionaryDomainServiceImpl implements DictionaryDomainService {

    private final DictionaryRepository dictionaryRepository;
    private final SnGenerateManagerService snGenerateManagerService;

    @Override
    public DictionaryDO addDictionary(DictionaryDO dictionaryDO) {
        dictionaryDO.create(snGenerateManagerService.generate(SnType.DICTIONARY_SN_TYPE));
        return dictionaryRepository.addDictionary(dictionaryDO);
    }
}
