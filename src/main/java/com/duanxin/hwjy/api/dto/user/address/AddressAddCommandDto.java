package com.duanxin.hwjy.api.dto.user.address;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author duanxin
 * @version 1.0
 * @className AddessAddCommandDto
 * @date 2021/02/06 09:56
 */
@Setter
@Getter
public class AddressAddCommandDto {

    private int userId;

    @NotBlank(message = "address name NotBlank")
    private String name;

    @NotBlank(message = "address province NotBlank")
    private String province;

    @NotBlank(message = "address city NotBlank")
    private String city;

    @NotBlank(message = "address county NotBlank")
    private String county;

    @NotBlank(message = "address addressDetails NotBlank")
    private String addressDetails;

    private String postalCode;

    @NotBlank(message = "address phone NotBlank")
    private String phone;
}
