package com.duanxin.hwjy.domain.mall.product.repository.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductCategoryDO;
import com.duanxin.hwjy.domain.mall.product.repository.ProductCategoryRepository;
import com.duanxin.hwjy.domain.mall.product.service.impl.ProductCategoryFactory;
import com.duanxin.hwjy.infrastructure.repository.mapper.ProductCategoryMapper;
import com.duanxin.hwjy.infrastructure.repository.po.ProductCategoryPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductCategoryRepositoryImpl
 * @date 2021/03/19 09:24
 */
@Repository
@AllArgsConstructor
@Slf4j
public class ProductCategoryRepositoryImpl implements ProductCategoryRepository {

    private final ProductCategoryMapper productCategoryMapper;
    private final ProductCategoryFactory productCategoryFactory;

    @Override
    public void addProductCategory(ProductCategoryDO categoryDO) {
        ProductCategoryPO po = productCategoryFactory.do2PO(categoryDO);
        productCategoryMapper.insert(po);
        log.info("success to insert ProductCategory [{}]", JsonUtil.toString(po));
    }

    @Override
    public List<ProductCategoryDO> getCategories() {
        return productCategoryMapper.selectAll().stream().
                map(productCategoryFactory::po2DO).collect(Collectors.toList());
    }

    @Override
    public ProductCategoryDO selectByName(String name) {
        ProductCategoryPO po = productCategoryMapper.selectByName(name);
        return Objects.isNull(po) ? null : productCategoryFactory.po2DO(po);
    }
}
