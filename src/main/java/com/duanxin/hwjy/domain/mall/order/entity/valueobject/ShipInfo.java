package com.duanxin.hwjy.domain.mall.order.entity.valueobject;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className ShipInfo
 * @date 2021/04/13 09:13
 */
@Setter
@Getter
public class ShipInfo {

    private String shipSn;

    private String shipChannel;

    private LocalDateTime shipTime;
}
