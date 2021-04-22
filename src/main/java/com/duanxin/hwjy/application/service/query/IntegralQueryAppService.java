package com.duanxin.hwjy.application.service.query;

import com.duanxin.hwjy.domain.user.entity.IntegralAccountDO;
import com.duanxin.hwjy.domain.user.repository.IntegralAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralQueryAppService
 * @date 2021/04/22 15:05
 */
@Service
@AllArgsConstructor
public class IntegralQueryAppService {

    private final IntegralAccountRepository integralAccountRepository;

    public IntegralAccountDO getIntegralAccount(String integralAccountSn) {
        return integralAccountRepository.selectBySn(integralAccountSn);
    }
}
