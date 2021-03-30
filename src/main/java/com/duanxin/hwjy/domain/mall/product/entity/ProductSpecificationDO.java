package com.duanxin.hwjy.domain.mall.product.entity;

import com.duanxin.hwjy.domain.mall.product.entity.valueobject.ProductGallery;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductSpecificationDO
 * @date 2021/03/30 10:05
 */
@Setter
@Getter
public class ProductSpecificationDO {

    private int id;

    private int productId;

    private String specification;

    private String value;

    private List<ProductGallery> gallery;

    private Deleted deleted = Deleted.VALID;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();
}
