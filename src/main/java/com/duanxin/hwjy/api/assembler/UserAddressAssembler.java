package com.duanxin.hwjy.api.assembler;

import com.duanxin.hwjy.api.dto.user.address.AddressAddCommandDto;
import com.duanxin.hwjy.api.dto.user.address.AddressQueryDto;
import com.duanxin.hwjy.api.dto.user.address.UserAddressDto;
import com.duanxin.hwjy.domain.user.entity.UserAddressDO;
import com.duanxin.hwjy.domain.user.entity.UserDO;
import com.duanxin.hwjy.domain.user.entity.valueobject.Acquiescence;
import org.springframework.beans.BeanUtils;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressAssembler
 * @date 2021/02/06 10:02
 */
public class UserAddressAssembler {

    private UserAddressAssembler() {

    }

    public static UserAddressDO dto2DO(UserAddressDto dto) {
        UserAddressDO userAddressDO = new UserAddressDO();
        BeanUtils.copyProperties(dto, userAddressDO);
        if (Objects.nonNull(dto.getAcquiescence())) {
            userAddressDO.setAcquiescence(Acquiescence.formatByDesc(dto.getAcquiescence()));
        }
        return userAddressDO;
    }

    public static UserAddressDO addCommandDto2DO(AddressAddCommandDto dto) {
        UserAddressDO addressDO = new UserAddressDO();
        BeanUtils.copyProperties(dto, addressDO);
        return addressDO;
    }

    public static AddressQueryDto userDO2QueryDto(UserDO userDO) {
        AddressQueryDto dto = new AddressQueryDto();
        dto.setUserId(userDO.getId());
        dto.setUserAddressDtos(userDO.getUserAddressDOS().stream().
                map(UserAddressAssembler::do2Dto).collect(Collectors.toList()));
        return dto;
    }

    public static UserAddressDto do2Dto(UserAddressDO userAddressDO) {
        UserAddressDto dto = new UserAddressDto();
        BeanUtils.copyProperties(userAddressDO, dto);
        dto.setAcquiescence(userAddressDO.getAcquiescence().getDesc());
        return dto;
    }
}
