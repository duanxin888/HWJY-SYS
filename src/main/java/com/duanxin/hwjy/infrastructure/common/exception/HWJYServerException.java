package com.duanxin.hwjy.infrastructure.common.exception;

/**
 * @author duanxin
 * @version 1.0
 * @className HWJYServerException
 * @date 2021/01/12 08:51
 */
public class HWJYServerException extends HWJYBaseException{

    public HWJYServerException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
