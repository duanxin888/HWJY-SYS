package com.duanxin.hwjy.api.facade;

import com.duanxin.hwjy.api.assembler.UserAddressAssembler;
import com.duanxin.hwjy.api.dto.user.address.AddressAddCommandDto;
import com.duanxin.hwjy.api.dto.user.address.UserAddressDto;
import com.duanxin.hwjy.application.service.command.UserAddressAppService;
import com.duanxin.hwjy.application.service.query.AddressQueryAppService;
import com.duanxin.hwjy.application.service.query.UserQueryAppService;
import com.duanxin.hwjy.domain.user.entity.UserAddressDO;
import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
    private final UserQueryAppService userQueryAppService;
    private final AddressQueryAppService addressQueryAppService;

    @PostMapping
    public ResponseResult addAddress(@RequestBody @Valid AddressAddCommandDto addressAddCommandDto) {
        UserAddressDO addressDO = UserAddressAssembler.addCommandDto2DO(addressAddCommandDto);
        userAddressAppService.addAddress(addressDO);
        return ResponseResult.success();
    }

    @GetMapping("/{userId}")
    public ResponseResult queryAddress(@PathVariable int userId) {
        return ResponseResult.success(UserAddressAssembler.userDO2QueryDto(
                userQueryAppService.queryAddress(userId)));
    }

    @PutMapping("/acquiescence")
    public ResponseResult updateAcquiescence(@RequestBody List<UserAddressDto> userAddressDtos) {
        List<UserAddressDO> dos = userAddressDtos.stream().
                map(UserAddressAssembler::dto2DO).collect(Collectors.toList());
        userAddressAppService.updateAcquiescence(dos);
        return ResponseResult.success();
    }

    @PutMapping
    public ResponseResult updateAddress(@RequestBody UserAddressDto dto) {
        userAddressAppService.updateAddress(UserAddressAssembler.dto2DO(dto));
        return ResponseResult.success();
    }

    @DeleteMapping("/{addressId}")
    public ResponseResult deleteAddress(@PathVariable int addressId) {
        userAddressAppService.deleteAddress(addressId);
        return ResponseResult.success();
    }

    @GetMapping("/addressId/{addressId}")
    public ResponseResult getAddressById(@PathVariable int addressId) {
        return ResponseResult.success(UserAddressAssembler.do2Dto(
                addressQueryAppService.getAddressById(addressId)));
    }

    @GetMapping("/acquiescence/{userId}")
    public ResponseResult getDefaultAddress(@PathVariable int userId) {
        return ResponseResult.success(UserAddressAssembler.do2Dto(
                addressQueryAppService.getDefaultAddress(userId)));
    }
}
