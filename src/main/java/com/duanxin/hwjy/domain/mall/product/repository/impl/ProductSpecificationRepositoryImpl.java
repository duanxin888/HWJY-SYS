package com.duanxin.hwjy.domain.mall.product.repository.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductSpecificationDO;
import com.duanxin.hwjy.domain.mall.product.repository.ProductSpecificationRepository;
import com.duanxin.hwjy.domain.mall.product.service.impl.ProductSpecificationFactory;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import com.duanxin.hwjy.infrastructure.repository.mapper.ProductSpecificationMapper;
import com.duanxin.hwjy.infrastructure.repository.po.ProductSpecificationPO;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductSpecificationRepositoryImpl
 * @date 2021/04/02 09:18
 */
@Repository
@AllArgsConstructor
@Slf4j
public class ProductSpecificationRepositoryImpl implements ProductSpecificationRepository {

    private final ProductSpecificationMapper productSpecificationMapper;
    private final ProductSpecificationFactory specificationFactory;

    @Override
    public void insert(ProductSpecificationDO specification) {
        ProductSpecificationPO po = specificationFactory.do2PO(specification);
        productSpecificationMapper.insert(po);
        log.info("success to insert ProductSpecification [{}]", JsonUtil.toString(po));
    }

    @Override
    public List<ProductSpecificationDO> selectByPid(int pid) {
        List<ProductSpecificationPO> pos = productSpecificationMapper.selectByPid(pid);
        return pos.stream().filter(f -> Deleted.isValid(f.getDeleted())).
                map(specificationFactory::po2DO).collect(Collectors.toList());
    }
}
