package com.duanxin.hwjy.infrastructure.repository.mapper;

import com.duanxin.hwjy.infrastructure.repository.po.UserAddressPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressMapper
 * @date 2021/01/10 08:50
 */
public interface UserAddressMapper {
    void insert(@Param("userAddress") UserAddressPO userAddress);
}
