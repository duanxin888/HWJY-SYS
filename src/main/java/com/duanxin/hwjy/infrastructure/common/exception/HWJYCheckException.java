package com.duanxin.hwjy.infrastructure.common.exception;

/**
 * @author duanxin
 * @version 1.0
 * @className HWJYCheckException
 * @date 2021/01/08 19:05
 */
public class HWJYCheckException extends HWJYBaseException{
    public HWJYCheckException(ResultEnum resultEnum) {
        super(resultEnum);
    }
}
