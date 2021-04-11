package com.duanxin.hwjy.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className UserCartPO
 * @date 2021/04/11 08:52
 */
@Setter
@Getter
public class UserCartPO {

    private int id;

    private int userId;

    private int cartStatus;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
