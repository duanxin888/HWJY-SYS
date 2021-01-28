package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.api.assembler.UserAssembler;
import com.duanxin.hwjy.api.dto.LoginCommandDto;
import com.duanxin.hwjy.application.service.command.UserAppService;
import com.duanxin.hwjy.domain.user.entity.UserDO;
import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author duanxin
 * @version 1.0
 * @className UserApi
 * @date 2021/01/09 20:19
 */
@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@Validated
public class UserApi {

    private final UserAppService userAppService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody @Valid LoginCommandDto loginCommandDto) {
        UserDO userDO = UserAssembler.loginCommand2DO(loginCommandDto);
        userDO = userAppService.login(userDO, loginCommandDto.getCode(), loginCommandDto.getAppid());
        return ResponseResult.success(UserAssembler.do2LoginResponse(userDO, loginCommandDto));
    }
}
