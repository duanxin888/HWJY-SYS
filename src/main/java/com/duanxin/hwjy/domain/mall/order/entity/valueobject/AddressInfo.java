package com.duanxin.hwjy.domain.mall.order.entity.valueobject;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className AddressInfo
 * @date 2021/04/13 09:09
 */
@Setter
@Getter
public class AddressInfo {

    private String name;

    private String province;

    private String city;

    private String county;

    private String addressDetails;

    private String postalCode;

    private String phone;
}
