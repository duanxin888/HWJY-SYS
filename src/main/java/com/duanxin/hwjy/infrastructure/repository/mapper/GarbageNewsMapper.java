package com.duanxin.hwjy.infrastructure.repository.mapper;

import com.duanxin.hwjy.infrastructure.repository.po.GarbageNewsPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author duanxin
 * @version 1.0
 * @className UserMapper
 * @date 2021/01/10 08:38
 */
public interface GarbageNewsMapper {

    void insert(@Param("garbageNews") GarbageNewsPO garbageNews);

    GarbageNewsPO selectByNewsTitle(@Param("newsTitle") String newsTitle);
}
