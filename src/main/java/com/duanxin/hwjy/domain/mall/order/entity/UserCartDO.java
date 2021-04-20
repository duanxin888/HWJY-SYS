package com.duanxin.hwjy.domain.mall.order.entity;

import com.duanxin.hwjy.domain.mall.order.entity.valueobject.CartOperateType;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.CartStatus;
import com.duanxin.hwjy.domain.mall.order.entity.valueobject.ProductInfo;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className UserOrderDO
 * @date 2021/04/11 10:07
 */
@Setter
@Getter
public class UserCartDO {

    private int id;

    private int userId;

    private CartStatus cartStatus;

    private LocalDateTime cdate = LocalDateTime.now();

    private String creator = Constants.CREATOR.getDesc();

    private LocalDateTime edate = LocalDateTime.now();

    private String editor = Constants.EDITOR.getDesc();

    private List<CartEventLogDO> eventLogs;

    public UserCartDO() {

    }

    public UserCartDO(Integer userId) {
        this.userId = userId;
        this.cartStatus = CartStatus.VALID;
    }

    public void dealLog(List<CartEventLogDO> logDOS) {
        Map<ProductInfo, List<CartEventLogDO>> map =
                logDOS.stream().collect(Collectors.groupingBy(CartEventLogDO::getProductInfo));
        List<CartEventLogDO> resList = new ArrayList<>(map.size());
        map.values().forEach(c -> resList.add(doDealLog(c)));
        this.setEventLogs(resList.stream().
                filter(f -> CartOperateType.PRODUCT_ADD.equals(f.getOperateType())).
                collect(Collectors.toList()));
    }

    private CartEventLogDO doDealLog(List<CartEventLogDO> logs) {
        CartEventLogDO logDO = logs.get(0);
        logs.stream().skip(1).forEach(c -> {
            logDO.setOperateQuantity(c.getOperateType().equals(CartOperateType.PRODUCT_ADD) ?
                    logDO.getOperateQuantity() + c.getOperateQuantity() :
                    logDO.getOperateQuantity() - c.getOperateQuantity());
        });
        logDO.setOperateType(logDO.getOperateQuantity() > 0 ?
                CartOperateType.PRODUCT_ADD : CartOperateType.PRODUCT_DELETED);
        return logDO;
    }

    public boolean check4Order(List<CartEventLogDO> orderLogs) {
        int cartOperateQuantity = this.getEventLogs().stream().
                map(CartEventLogDO::getOperateQuantity).reduce(0, Integer::sum);
        int orderOperateQuantity = orderLogs.stream().
                map(CartEventLogDO::getOperateQuantity).reduce(0, Integer::sum);
        return cartOperateQuantity == orderOperateQuantity;
    }
}
