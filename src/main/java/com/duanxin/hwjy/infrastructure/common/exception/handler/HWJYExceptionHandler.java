package com.duanxin.hwjy.infrastructure.common.exception.handler;

import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author duanxin
 * @version 1.0
 * @className HWJYExceptionHandler
 * @date 2021/01/08 19:05
 */
@ControllerAdvice
public class HWJYExceptionHandler {

    @ExceptionHandler(HWJYCheckException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseResult hwjyCheckExceptionHandler(HWJYCheckException exception) {
        ResultEnum resultEnum = exception.getResultEnum();
        return ResponseResult.error(resultEnum.getCode(), resultEnum.getDesc());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseResult paramCheckException(MethodArgumentNotValidException exception) {
        return ResponseResult.error(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult exceptionHandle(Exception ex) {
        return ResponseResult.error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage());
    }
}
