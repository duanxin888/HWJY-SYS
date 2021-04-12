package com.duanxin.hwjy.domain.mall.order.entity;

import com.duanxin.hwjy.domain.mall.order.entity.valueobject.CartStatus;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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
}
