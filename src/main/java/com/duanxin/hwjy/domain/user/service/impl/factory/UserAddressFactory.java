package com.duanxin.hwjy.domain.user.service.impl.factory;

import com.duanxin.hwjy.domain.user.entity.UserAddressDO;
import com.duanxin.hwjy.domain.user.entity.valueobject.Acquiescence;
import com.duanxin.hwjy.infrastructure.common.enums.Deleted;
import com.duanxin.hwjy.infrastructure.repository.po.UserAddressPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author duanxin
 * @version 1.0
 * @className UserAddressFactory
 * @date 2021/02/06 10:16
 */
@Component
public class UserAddressFactory {

    public UserAddressPO createUserAddressPO(UserAddressDO userAddressDO) {
        UserAddressPO po = new UserAddressPO();
        BeanUtils.copyProperties(userAddressDO, po);
        po.setAcquiescence(userAddressDO.getAcquiescence().getCode());
        po.setDeleted(userAddressDO.getDeleted().getCode());
        return po;
    }

    public UserAddressDO createUserAddressDO(UserAddressPO po) {
        UserAddressDO userAddressDO = new UserAddressDO();
        BeanUtils.copyProperties(po, userAddressDO);
        userAddressDO.setAcquiescence(Acquiescence.formatByCode(po.getAcquiescence()));
        userAddressDO.setDeleted(Deleted.formatByCode(po.getDeleted()));
        return userAddressDO;
    }
}
