package com.duanxin.hwjy.domain.mall.order.service;

import com.duanxin.hwjy.domain.mall.order.entity.CartEventLogDO;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.ProductInfo;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className CartDomainService
 * @date 2021/04/11 10:50
 */
public interface CartDomainService {

    void modifyCart(Integer userId, CartEventLogDO eventLogDO);

    void dealCarts4Order(int userId, List<ProductInfo> productInfos);
}
