package com.duanxin.hwjy.domain.mall.product.entity;

import com.duanxin.hwjy.domain.mall.product.entity.valueobject.OnSale;
import com.duanxin.hwjy.domain.mall.product.entity.valueobject.TransactionRule;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @className ProductDO
 * @date 2021/03/29 11:11
 */
@Setter
@Getter
public class ProductDO {

    private int id;

    private String name;

    private int cid;

    private String picUrl;

    private String productSn;

    private String details;

    private int sorted;

    private TransactionRule transactionRule;

    private String brief;

    private OnSale onSale;

    private Deleted deleted = Deleted.VALID;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();

    private List<ProductSpecificationDO> productSpecifications;

    private List<ProductAttributeDO> productAttributes;

    private List<ProductStockDO> productStocks;

    public void fillSn(String sn) {
        this.setProductSn(sn);
    }
}
