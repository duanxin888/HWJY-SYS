package com.duanxin.hwjy.domain.mall.product.repository.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductDO;
import com.duanxin.hwjy.domain.mall.product.repository.ProductRepository;
import com.duanxin.hwjy.domain.mall.product.service.impl.ProductFactory;
import com.duanxin.hwjy.infrastructure.repository.mapper.ProductMapper;
import com.duanxin.hwjy.infrastructure.repository.po.ProductPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductRepositoryImpl
 * @date 2021/04/02 09:06
 */
@Repository
@AllArgsConstructor
@Slf4j
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductMapper productMapper;
    private final ProductFactory productFactory;

    @Override
    public int insert(ProductDO productDO) {
        ProductPO po = productFactory.do2PO(productDO);
        productMapper.insert(po);
        log.info("success to insert product [{}]", JsonUtil.toString(po));
        return po.getId();
    }

    @Override
    public ProductDO selectByName(String name) {
        ProductPO po = productMapper.selectByName(name);
        return null;
    }
}
