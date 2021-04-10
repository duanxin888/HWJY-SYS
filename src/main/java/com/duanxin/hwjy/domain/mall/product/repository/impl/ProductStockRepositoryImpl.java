package com.duanxin.hwjy.domain.mall.product.repository.impl;

import com.duanxin.hwjy.domain.mall.product.entity.ProductStockDO;
import com.duanxin.hwjy.domain.mall.product.repository.ProductStockRepository;
import com.duanxin.hwjy.domain.mall.product.service.impl.ProductStockFactory;
import com.duanxin.hwjy.infrastructure.repository.mapper.ProductStockMapper;
import com.duanxin.hwjy.infrastructure.repository.po.ProductStockPO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductStockRepositoryImpl
 * @date 2021/04/08 09:04
 */
@Repository
@Slf4j
@AllArgsConstructor
public class ProductStockRepositoryImpl implements ProductStockRepository {

    private final ProductStockMapper stockMapper;
    private final ProductStockFactory stockFactory;

    @Override
    public List<ProductStockDO> selectByPid(int pid) {
        List<ProductStockPO> pos = stockMapper.selectByPid(pid);
        return pos.stream().map(stockFactory::po2DO).collect(Collectors.toList());
    }
}
