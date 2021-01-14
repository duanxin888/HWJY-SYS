package com.duanxin.hwjy.infrastructure.client.sn;

import com.duanxin.hwjy.infrastructure.common.enums.SnType;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author duanxin
 * @version 1.0
 * @className SnGenerateManagerService
 * @date 2021/01/14 11:24
 */
@Service
public class SnGenerateManagerService {

    private final List<AbsSnGenerator> snGenerators;
    private Map<SnType, AbsSnGenerator> snGeneratorMap;

    public SnGenerateManagerService(List<AbsSnGenerator> snGenerators) {
        this.snGenerators = snGenerators;
        init();
    }

    private void init() {
        Map<SnType, AbsSnGenerator> map = snGenerators.stream().
                collect(Collectors.toMap(AbsSnGenerator::getSupportType, s -> s));
        snGeneratorMap = Collections.unmodifiableMap(map);
    }

    public String generate(SnType snType) {
        return Optional.ofNullable(snGeneratorMap.get(snType)).
                orElseThrow(() -> new HWJYCheckException(ResultEnum.NO_SUPPORT_SN_GENERATOR)).generate();
    }
}
