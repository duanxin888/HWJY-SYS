package com.duanxin.hwjy.api.dto.user.address;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressDto
 * @date 2021/02/06 11:47
 */
@Setter
@Getter
public class UserAddressDto {

    private int id;

    private String name;

    private int userId;

    private String province;

    private String city;

    private String county;

    private String addressDetails;

    private String postalCode;

    private String phone;

    private String acquiescence;
}
