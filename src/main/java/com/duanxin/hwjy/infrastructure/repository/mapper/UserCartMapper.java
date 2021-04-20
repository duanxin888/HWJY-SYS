package com.duanxin.hwjy.infrastructure.repository.mapper;

import com.duanxin.hwjy.infrastructure.repository.po.UserCartPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author duanxin
 * @version 1.0
 * @className UserCartMapper
 * @date 2021/04/11 08:53
 */
public interface UserCartMapper {
    UserCartPO selectValidCart(@Param("userId") Integer userId,
                               @Param("cartStatus") int validCartStatus);

    void insert(@Param("po") UserCartPO po);

    void updateStatus2Invalid(@Param("id") int id,
                              @Param("status") int status);
}
