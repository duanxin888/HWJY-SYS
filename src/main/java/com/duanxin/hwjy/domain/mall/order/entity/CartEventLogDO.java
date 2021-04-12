package com.duanxin.hwjy.domain.mall.order.entity;

import com.duanxin.hwjy.domain.mall.order.entity.valueobject.CartOperateType;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.ProductInfo;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author duanxin
 * @version 1.0
 * @className CartEventLogDO
 * @date 2021/04/11 10:09
 */
@Setter
@Getter
public class CartEventLogDO {

    private int id;

    private int cartId;

    private ProductInfo productInfo;

    private CartOperateType operateType;

    private int operateQuantity;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();

    public void create(int cartId) {
        this.setCartId(cartId);
    }
}
