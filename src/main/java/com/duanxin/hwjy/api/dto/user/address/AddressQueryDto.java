package com.duanxin.hwjy.api.dto.user.address;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className AddressQueryDto
 * @date 2021/02/06 11:40
 */
@Setter
@Getter
public class AddressQueryDto {

    private int userId;

    private List<UserAddressDto> userAddressDtos;
}
