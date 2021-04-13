package com.duanxin.hwjy.domain.mall.order.entity.valueobject;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className OrderDetails
 * @date 2021/04/13 09:28
 */
@Setter
@Getter
public class OrderDetails {

    private List<ProductInfo> productInfos;
}
