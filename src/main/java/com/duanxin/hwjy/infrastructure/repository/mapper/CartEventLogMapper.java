package com.duanxin.hwjy.infrastructure.repository.mapper;

import com.duanxin.hwjy.infrastructure.repository.po.CartEventLogPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className CartEventLogMapper
 * @date 2021/04/11 08:58
 */
public interface CartEventLogMapper {
    void insert(@Param("po") CartEventLogPO po);

    List<CartEventLogPO> selectByCartId(@Param("cartId") int cartId);
}
