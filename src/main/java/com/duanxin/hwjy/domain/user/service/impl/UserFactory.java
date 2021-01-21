package com.duanxin.hwjy.domain.user.service.impl;

import com.duanxin.hwjy.domain.user.entity.IntegralAccountDO;
import com.duanxin.hwjy.domain.user.entity.UserDO;
import com.duanxin.hwjy.infrastructure.repository.po.IntegralAccountPO;
import com.duanxin.hwjy.infrastructure.repository.po.UserPO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author duanxin
 * @version 1.0
 * @className UserFactory
 * @date 2021/01/14 10:10
 */
@Component
public class UserFactory {

    public UserDO createUserDO(UserPO po, IntegralAccountDO integralAccountDO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(po, userDO);
        userDO.setIntegralAccount(integralAccountDO);
        return userDO;
    }

    public UserPO createUserPO(UserDO userDO) {
        UserPO po = new UserPO();
        BeanUtils.copyProperties(userDO, po);
        po.setStatus(userDO.getStatus().getCode());
        po.setDeleted(userDO.getDeleted().getCode());
        po.setIntegralAccountSn(userDO.getIntegralAccount().getIntegralAccountSn());
        return po;
    }

    public IntegralAccountPO createIntegralAccountPO(IntegralAccountDO integralAccountDO) {
        IntegralAccountPO po = new IntegralAccountPO();
        BeanUtils.copyProperties(integralAccountDO, po);
        po.setDeleted(integralAccountDO.getDeleted().getCode());
        po.setStatus(integralAccountDO.getStatus().getCode());
        return po;
    }

    public IntegralAccountDO createIntegralAccountDO(IntegralAccountPO po) {
        IntegralAccountDO integralAccountDO = new IntegralAccountDO(po.getIntegralAccountSn());
        integralAccountDO.setId(po.getId());
        integralAccountDO.setIntegralBalance(po.getIntegralBalance());
        return integralAccountDO;
    }
}
