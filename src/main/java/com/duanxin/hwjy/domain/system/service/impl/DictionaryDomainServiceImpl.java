package com.duanxin.hwjy.domain.system.service.impl;

import com.duanxin.hwjy.domain.system.entity.DictionaryDO;
import com.duanxin.hwjy.domain.system.entity.valueobject.DictionaryItem;
import com.duanxin.hwjy.domain.system.entity.valueobject.DictionaryStatus;
import com.duanxin.hwjy.domain.system.repository.DictionaryRepository;
import com.duanxin.hwjy.domain.system.service.DictionaryDomainService;
import com.duanxin.hwjy.infrastructure.client.sn.SnGenerateManagerService;
import com.duanxin.hwjy.infrastructure.common.enums.SnType;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    @Override
    public void updateItem(DictionaryDO dictionaryDO) {
        checkValidityBySn(dictionaryDO.getDictionarySn());
        dictionaryRepository.updateItem(dictionaryDO);
    }

    @Override
    public String getItemValue(String dictionaryName, String itemName) {
        DictionaryDO dictionaryDO = dictionaryRepository.selectByName(dictionaryName);
        checkValidity(dictionaryDO);
        DictionaryItem dictionaryItem = dictionaryDO.fetchItemByName(itemName);
        return dictionaryItem.getValue();
    }

    private void checkValidity(DictionaryDO dictionaryDO) {
        if (Objects.isNull(dictionaryDO) || !DictionaryStatus.isAvailable(dictionaryDO.getDictionaryStatus())) {
            log.warn("dictionary [{}] is not exist or invalidity", JsonUtil.toString(dictionaryDO));
            throw new HWJYCheckException(ResultEnum.DICTIONARY_NOT_EXIST);
        }
    }

    private void checkValidityBySn(String dictionarySn) {
        DictionaryDO dictionaryDO = dictionaryRepository.selectBySn(dictionarySn);
        checkValidity(dictionaryDO);
    }
}
