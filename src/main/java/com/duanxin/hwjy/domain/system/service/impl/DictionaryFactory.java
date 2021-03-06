package com.duanxin.hwjy.domain.system.service.impl;

import com.duanxin.hwjy.domain.system.entity.DictionaryDO;
import com.duanxin.hwjy.domain.system.entity.valueobject.DictionaryItem;
import com.duanxin.hwjy.domain.system.entity.valueobject.DictionaryStatus;
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

    public DictionaryPO createDictionaryPO(DictionaryDO dictionaryDO) {
        DictionaryPO po = new DictionaryPO();
        BeanUtils.copyProperties(dictionaryDO, po);
        po.setDictionaryStatus(dictionaryDO.getDictionaryStatus().name());
        po.setDictionaryItem(JsonUtil.toString(dictionaryDO.getDictionaryItems()));
        return po;
    }

    public DictionaryDO createDictionaryDO(DictionaryPO po) {
        DictionaryDO dictionaryDO = new DictionaryDO();
        BeanUtils.copyProperties(po, dictionaryDO);
        dictionaryDO.setDictionaryStatus(DictionaryStatus.formatByName(po.getDictionaryStatus()));
        dictionaryDO.setDictionaryItems(JsonUtil.toObjectList(po.getDictionaryItem(), DictionaryItem.class).get());
        return dictionaryDO;
    }
}
