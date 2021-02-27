package com.duanxin.hwjy.infrastructure.repository.po;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralLogPO
 * @date 2021/02/27 08:41
 */
@Setter
@Getter
public class IntegralLogPO {
    
    private int id;
    
    private int userId;
    
    private String integralAccountSn;
    
    private String operateType;
    
    private String integralOperateChannel;
    
    private BigDecimal integralNumber;
    
    private String operateParam;

    private LocalDateTime cdate;

    private String creator;

    private LocalDateTime edate;

    private String editor;
}
