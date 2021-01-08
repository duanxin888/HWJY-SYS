package com.duanxin.hwjy.infrastructure.common.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author duanxin
 * @version 1.0
 * @className ResponseResult
 * @date 2021/01/08 18:59
 */
@Getter
@Setter
public class ResponseResult {

    private int code;
    private String msg;
    private Object data;

    private ResponseResult() {}

    public static ResponseResult success() {
        ResponseResult result = new ResponseResult();
        result.setMsg("operator success!");
        return result;
    }

    public static ResponseResult success(Object data) {
        ResponseResult result = new ResponseResult();
        result.setMsg("operator success!");
        result.setData(data);
        return result;
    }

    public static ResponseResult error(int code, String msg, Object data) {
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static ResponseResult error(int code, String msg) {
        return error(code, msg, null);
    }

    public static ResponseResult error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static ResponseResult error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "unknown error, please contact the administrator");
    }
}
