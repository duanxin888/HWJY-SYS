package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.api.assembler.UserAddressAssembler;
import com.duanxin.hwjy.api.dto.user.address.AddressAddCommandDto;
import com.duanxin.hwjy.application.service.command.UserAddressAppService;
import com.duanxin.hwjy.domain.user.entity.UserAddressDO;
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
 * @className UserAddressApi
 * @date 2021/02/06 09:38
 */
@RestController
@RequestMapping("/api/v1/users/address")
@AllArgsConstructor
@Validated
public class UserAddressApi {

    private final UserAddressAppService userAddressAppService;

    @PostMapping
    public ResponseResult addAddress(@RequestBody @Valid AddressAddCommandDto addressAddCommandDto) {
        UserAddressDO addressDO = UserAddressAssembler.addCommandDto2DO(addressAddCommandDto);
        userAddressAppService.addAddress(addressDO);
        return ResponseResult.success();
    }
}
