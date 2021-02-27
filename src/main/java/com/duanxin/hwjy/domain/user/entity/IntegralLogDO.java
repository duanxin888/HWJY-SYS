package com.duanxin.hwjy.domain.user.entity;

import com.duanxin.hwjy.domain.user.entity.valueobject.IntegralOperateChannel;
import com.duanxin.hwjy.domain.user.entity.valueobject.IntegralOperateType;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralLogDO
 * @date 2021/02/27 10:29
 */
@Setter
@Getter
public class IntegralLogDO {

    private int id;

    private int userId;

    private String integralAccountSn;

    private IntegralOperateType operateType;

    private IntegralOperateChannel integralOperateChannel;

    private BigDecimal integralNumber;

    private String operateParam;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();
}
