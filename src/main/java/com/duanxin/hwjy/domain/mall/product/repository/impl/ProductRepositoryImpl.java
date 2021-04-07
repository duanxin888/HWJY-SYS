package com.duanxin.hwjy.domain.mall.product.repository.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductDO;
import com.duanxin.hwjy.domain.mall.product.entity.valueobject.OnSale;
import com.duanxin.hwjy.domain.mall.product.repository.ProductRepository;
import com.duanxin.hwjy.domain.mall.product.service.impl.ProductFactory;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import com.duanxin.hwjy.infrastructure.repository.mapper.ProductMapper;
import com.duanxin.hwjy.infrastructure.repository.po.ProductPO;
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
        return Objects.isNull(po) ? null : productFactory.po2DO(po);
    }

    @Override
    public List<ProductDO> getProductsByCid(int cid) {
        List<ProductPO> pos = productMapper.selectProductsByCid(cid);
        return pos.stream().filter(f -> Deleted.isValid(f.getDeleted()) && OnSale.isOnSale(f.getOnSale())).
                map(productFactory::po2DO).collect(Collectors.toList());
    }
}
