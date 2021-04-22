package com.duanxin.hwjy.api.assembler;

import com.duanxin.hwjy.api.dto.user.integral.IntegralAccountQueryResponseDto;
import com.duanxin.hwjy.api.dto.user.integral.IntegralAddCommandDto;
import com.duanxin.hwjy.domain.user.entity.IntegralAccountDO;
import com.duanxin.hwjy.domain.user.entity.IntegralLogDO;
import org.springframework.beans.BeanUtils;

/**
 * @author duanxin
 * @version 1.0
 * @className IntegralAssembler
 * @date 2021/03/02 10:25
 */
public class IntegralAssembler {

    private IntegralAssembler() {
    }

    public static IntegralLogDO addCommand2LogDO(IntegralAddCommandDto dto) {
        IntegralLogDO logDO = new IntegralLogDO();
        BeanUtils.copyProperties(dto, logDO);
        return logDO;
    }

    public static IntegralAccountQueryResponseDto do2QueryResponseDto(IntegralAccountDO accountDO) {
        IntegralAccountQueryResponseDto dto = new IntegralAccountQueryResponseDto();
        BeanUtils.copyProperties(accountDO, dto);
        return dto;
    }
}
