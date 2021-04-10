package com.duanxin.hwjy.domain.mall.product.repository.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductAttributeDO;
import com.duanxin.hwjy.domain.mall.product.repository.ProductAttributeRepository;
import com.duanxin.hwjy.domain.mall.product.service.impl.ProductAttributeFactory;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import com.duanxin.hwjy.infrastructure.repository.mapper.ProductAttributeMapper;
import com.duanxin.hwjy.infrastructure.repository.po.ProductAttributePO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductAttributeRepositoryImpl
 * @date 2021/04/02 09:20
 */
@Repository
@AllArgsConstructor
@Slf4j
public class ProductAttributeRepositoryImpl implements ProductAttributeRepository {

    private final ProductAttributeMapper productAttributeMapper;
    private final ProductAttributeFactory productAttributeFactory;

    @Override
    public void insert(ProductAttributeDO attribute) {
        ProductAttributePO po = productAttributeFactory.do2PO(attribute);
        productAttributeMapper.insert(po);
        log.info("success to insert productAttribute [{}]", JsonUtil.toString(po));
    }

    @Override
    public List<ProductAttributeDO> selectByPid(int pid) {
        List<ProductAttributePO> pos = productAttributeMapper.selectByPid(pid);
        return pos.stream().filter(f -> Deleted.isValid(f.getDeleted())).
                map(productAttributeFactory::po2DO).collect(Collectors.toList());
    }
}
