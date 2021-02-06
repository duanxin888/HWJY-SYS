package com.duanxin.hwjy.api.dto.user.login;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


/**
 * @author duanxin
 * @version 1.0
 * @className LoginCommandDto
 * @date 2021/01/09 20:30
 */
@Getter
@Setter
public class LoginCommandDto {

    @NotBlank(message = "nickname NotBlank")
    private String nickname;

    @NotBlank(message = "avatarUrl NotBlank")
    private String avatarUrl;

    private String country;

    private String province;

    private String city;

    private String language;

    private int gender;

    @NotBlank(message = "code NotBlank")
    private String code;

    @NotBlank(message = "appid NotBlank")
    private String appid;
}
