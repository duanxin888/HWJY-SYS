package com.duanxin.hwjy.domain.mall.product.service.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductStockDO;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import com.duanxin.hwjy.infrastructure.repository.po.ProductStockPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductStockFactory
 * @date 2021/04/08 09:07
 */
@Component
public class ProductStockFactory {

    public ProductStockDO po2DO(ProductStockPO po) {
        if (Objects.isNull(po)) {
            throw new HWJYCheckException(ResultEnum.PRODUCT_STOCK_NOT_EXIST);
        }
        ProductStockDO stockDO = new ProductStockDO();
        BeanUtils.copyProperties(po, stockDO);
        return stockDO;
    }
}
