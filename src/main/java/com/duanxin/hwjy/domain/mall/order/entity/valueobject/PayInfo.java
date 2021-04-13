package com.duanxin.hwjy.domain.mall.order.entity.valueobject;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className PayInfo
 * @date 2021/04/13 09:11
 */
@Setter
@Getter
public class PayInfo {

    private String paySn;

    private String payType;

    private LocalDateTime payTime;
}
