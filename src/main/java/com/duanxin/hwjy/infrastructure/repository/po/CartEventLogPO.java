package com.duanxin.hwjy.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className CartEventLogPO
 * @date 2021/04/11 08:56
 */
@Setter
@Getter
public class CartEventLogPO {

    private int id;

    private int cartId;

    private String productInfo;

    private int operateType;

    private int operateQuantity;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
