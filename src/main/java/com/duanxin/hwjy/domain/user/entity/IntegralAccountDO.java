package com.duanxin.hwjy.domain.user.entity;

import com.duanxin.hwjy.domain.user.entity.valueobject.IntegralAccountStatus;
import com.duanxin.hwjy.infrastructure.common.enums.Constants;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralAccountDO
 * @date 2021/01/10 09:11
 */
@Setter
@Getter
public class IntegralAccountDO {

    private int id;

    private String IntegralAccountSn;

    private BigDecimal integralBalance = BigDecimal.ZERO;

    private LocalDateTime integralValidityDate;

    private IntegralAccountStatus status = IntegralAccountStatus.AVAILABLE;

    private Deleted deleted = Deleted.VALID;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();
}
