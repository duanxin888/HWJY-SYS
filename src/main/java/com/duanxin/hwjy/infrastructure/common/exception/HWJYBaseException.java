package com.duanxin.hwjy.infrastructure.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author duanxin
 * @version 1.0
 * @className HWJYBaseException
 * @date 2021/01/08 19:02
 */
public abstract class HWJYBaseException extends RuntimeException{

    @Getter
    @Setter
    private ResultEnum resultEnum;

    public HWJYBaseException(ResultEnum resultEnum) {
        super(resultEnum.getDesc());
        this.resultEnum = resultEnum;
    }
}
