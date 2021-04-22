package com.duanxin.hwjy.infrastructure.repository.mapper;

import com.duanxin.hwjy.infrastructure.repository.OrderCountsDto;
import com.duanxin.hwjy.infrastructure.repository.po.UserOrderPO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className UserOrderMapper
 * @date 2021/04/13 08:54
 */
public interface UserOrderMapper {
    void insert(@Param("po") UserOrderPO po);

    OrderCountsDto selectOrderCounts(@Param("userId") int userId);

    List<UserOrderPO> selectAll(@Param("userId") Integer userId);

    List<UserOrderPO> selectByStatus(@Param("userId") Integer userId,
                          @Param("orderStatus") String orderStatus);

    List<UserOrderPO> selectOvertimeUnpaid(@Param("limitTime") LocalDateTime limitTime);

    void updateWithCancelOrder(@Param("id") int id,
                               @Param("status") String status,
                               @Param("orderCloseTime") LocalDateTime orderCloseTime,
                               @Param("edate") LocalDateTime edate);
}
