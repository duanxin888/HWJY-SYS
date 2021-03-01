package com.duanxin.hwjy.application.service.command;

import com.duanxin.hwjy.domain.system.entity.DictionaryDO;
import com.duanxin.hwjy.domain.system.service.DictionaryDomainService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryAppService
 * @date 2021/02/27 20:43
 */
@Service
@AllArgsConstructor
@Slf4j
public class DictionaryAppService {

    private final DictionaryDomainService dictionaryDomainService;

    public DictionaryDO addDictionary(DictionaryDO dictionaryDO) {
        return dictionaryDomainService.addDictionary(dictionaryDO);
    }
}
