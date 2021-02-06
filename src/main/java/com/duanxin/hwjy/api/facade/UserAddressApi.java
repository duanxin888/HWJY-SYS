package com.duanxin.hwjy.api.facade;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
