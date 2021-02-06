package com.duanxin.hwjy.api.assembler;

import com.duanxin.hwjy.api.dto.user.address.AddressAddCommandDto;
import com.duanxin.hwjy.domain.user.entity.UserAddressDO;
import org.springframework.beans.BeanUtils;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressAssembler
 * @date 2021/02/06 10:02
 */
public class UserAddressAssembler {

    private UserAddressAssembler() {

    }

    public static UserAddressDO addCommandDto2DO(AddressAddCommandDto dto) {
        UserAddressDO addressDO = new UserAddressDO();
        BeanUtils.copyProperties(dto, addressDO);
        return addressDO;
    }
}
