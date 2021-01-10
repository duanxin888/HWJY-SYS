package com.duanxin.hwjy.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressPO
 * @date 2021/01/10 08:48
 */
@Setter
@Getter
public class UserAddressPO {

    private int id;

    private String name;

    private int userId;

    private String province;

    private String city;

    private String county;

    private String addressDetails;

    private String postalCode;

    private String phone;

    private int acquiescence;

    private int deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
