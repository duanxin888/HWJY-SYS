package com.duanxin.hwjy.application.service.query;

import com.duanxin.hwjy.domain.system.entity.DictionaryDO;
import com.duanxin.hwjy.domain.system.entity.valueobject.DictionaryStatus;
import com.duanxin.hwjy.domain.system.repository.DictionaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryQueryAppService
 * @date 2021/03/02 09:55
 */
@Service
@AllArgsConstructor
public class DictionaryQueryAppService {

    private final DictionaryRepository dictionaryRepository;

    public List<DictionaryDO> getDictionary() {
        return dictionaryRepository.getDictionary().stream().
                filter(f -> DictionaryStatus.isAvailable(f.getDictionaryStatus())).collect(Collectors.toList());
    }
}
