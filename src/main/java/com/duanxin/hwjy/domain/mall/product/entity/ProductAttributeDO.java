package com.duanxin.hwjy.domain.mall.product.entity;

import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductAttributeDO
 * @date 2021/03/30 10:29
 */
@Setter
@Getter
public class ProductAttributeDO {

    private int id;

    private int productId;

    private String attribute;

    private String value;

    private Deleted deleted = Deleted.VALID;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();

    public void fillProductId(int productId) {
        this.setProductId(productId);
    }
}
