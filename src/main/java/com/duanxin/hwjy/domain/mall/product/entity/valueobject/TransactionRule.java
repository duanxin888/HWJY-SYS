package com.duanxin.hwjy.domain.mall.product.entity.valueobject;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author duanxin
 * @version 1.0
 * @className TransactionRule
 * @date 2021/03/30 11:15
 */
@Setter
@Getter
public class TransactionRule {

    private TransactionType transactionType = TransactionType.POINTS_TRANSACTION;

    private BigDecimal transactionNum = BigDecimal.ZERO;
}
