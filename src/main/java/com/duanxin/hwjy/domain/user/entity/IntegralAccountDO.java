package com.duanxin.hwjy.domain.user.entity;

import com.duanxin.hwjy.domain.user.entity.valueobject.IntegralAccountStatus;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import com.duanxin.hwjy.infrastructure.util.DateUtil;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

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

    private String integralAccountSn;

    private BigDecimal integralBalance = BigDecimal.ZERO;

    private LocalDateTime integralValidityDate;

    private IntegralAccountStatus status = IntegralAccountStatus.AVAILABLE;

    private Deleted deleted = Deleted.VALID;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();

    public IntegralAccountDO(String integralAccountSn) {
        this.integralAccountSn = integralAccountSn;
        this.integralValidityDate = LocalDateTime.of(fetchLastDate4Year(), LocalTime.MAX);
    }

    public void fillId(int id) {
        this.setId(id);
    }

    private LocalDate fetchLastDate4Year() {
        return DateUtil.getYearLast(LocalDateTime.now().getYear()).
                toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public void increaseIncome(BigDecimal integralNumber) {
        this.setIntegralBalance(this.getIntegralBalance().add(integralNumber).setScale(2));
        this.setEdate(LocalDateTime.now());
    }
}
