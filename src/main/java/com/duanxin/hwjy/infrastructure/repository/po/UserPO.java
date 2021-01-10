package com.duanxin.hwjy.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserPO
 * @date 2021/01/10 08:21
 */
@Setter
@Getter
public class UserPO {

    private int id;

    private String phone;

    private String userImgUrl;

    private String integralAccountSn;

    private String nickname;

    private String wxOpenid;

    private String wxSessionKey;

    private int status;

    private int deleted;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
