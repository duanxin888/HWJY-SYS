package com.duanxin.hwjy.domain.system.service.impl;

import com.duanxin.hwjy.domain.system.entity.DictionaryDO;
import com.duanxin.hwjy.infrastructure.repository.po.DictionaryPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryFactory
 * @date 2021/03/01 20:30
 */
@Service
public class DictionaryFactory {

    public DictionaryPO do2PO(DictionaryDO dictionaryDO) {
        DictionaryPO po = new DictionaryPO();
        BeanUtils.copyProperties(dictionaryDO, po);
        po.setDictionaryStatus(dictionaryDO.getDictionaryStatus().name());
        po.setDictionaryItem(JsonUtil.toString(dictionaryDO.getDictionaryItems()));
        return po;
    }
}
