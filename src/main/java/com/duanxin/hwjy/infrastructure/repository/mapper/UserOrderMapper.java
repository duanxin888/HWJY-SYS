package com.duanxin.hwjy.infrastructure.repository.mapper;

import com.duanxin.hwjy.infrastructure.repository.po.UserOrderPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author duanxin
 * @version 1.0
 * @className UserOrderMapper
 * @date 2021/04/13 08:54
 */
public interface UserOrderMapper {
    void insert(@Param("po") UserOrderPO po);
}
