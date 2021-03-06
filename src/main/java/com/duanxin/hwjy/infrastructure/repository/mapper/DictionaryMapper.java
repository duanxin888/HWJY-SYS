package com.duanxin.hwjy.infrastructure.repository.mapper;

import com.duanxin.hwjy.infrastructure.repository.po.DictionaryPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className DictionaryMapper
 * @date 2021/02/27 11:09
 */
public interface DictionaryMapper {
    void insert(@Param("po") DictionaryPO po);

    DictionaryPO selectBySn(@Param("dictionarySn") String dictionarySn);

    void updateItem(@Param("po") DictionaryPO po);

    List<DictionaryPO> select();

    DictionaryPO selectByName(@Param("dictionaryName") String dictionaryName);
}
