package com.duanxin.hwjy.api.assembler;

import com.duanxin.hwjy.api.dto.cart.CartQueryResponseDto;
import com.duanxin.hwjy.api.dto.cart.CartUpdateCommandDto;
import com.duanxin.hwjy.domain.mall.order.entity.CartEventLogDO;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.CartOperateType;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.ProductInfo;
import org.springframework.beans.BeanUtils;

/**
 * @author duanxin
 * @version 1.0
 * @className CartEventLogAssembler
 * @date 2021/04/12 09:02
 */
public class CartEventLogAssembler {

    private CartEventLogAssembler() {
    }

    public static CartEventLogDO commandDto2DO(CartUpdateCommandDto dto) {
        CartEventLogDO logDO = new CartEventLogDO();
        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(dto, productInfo);
        logDO.setProductInfo(productInfo);
        logDO.setOperateQuantity(dto.getQuantity());
        logDO.setOperateType(CartOperateType.formatByCode(dto.getOperateType()));
        return logDO;
    }

    public static CartQueryResponseDto do2QueryResDto(CartEventLogDO logDO) {
        CartQueryResponseDto dto = new CartQueryResponseDto();
        BeanUtils.copyProperties(logDO.getProductInfo(), dto);
        dto.setCartId(logDO.getCartId());
        dto.setQuantity(logDO.getOperateQuantity());
        return dto;
    }
}
