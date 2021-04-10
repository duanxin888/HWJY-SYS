package com.duanxin.hwjy.infrastructure.repository.mapper;

import com.duanxin.hwjy.infrastructure.repository.po.ProductPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductMapper
 * @date 2021/03/29 10:53
 */
public interface ProductMapper {
    void insert(@Param("po") ProductPO po);

    ProductPO selectByName(@Param("name") String name);

    List<ProductPO> selectProductsByCid(@Param("cid") int cid,
                                        @Param("offset") int offset,
                                        @Param("rows") int rows);

    ProductPO selectById(@Param("id") int id);
}
