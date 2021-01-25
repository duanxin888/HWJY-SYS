package com.duanxin.hwjy.infrastructure.interceptor;

import com.duanxin.hwjy.infrastructure.client.token.JwtClientImpl;
import com.duanxin.hwjy.infrastructure.common.api.ResponseResult;
import com.duanxin.hwjy.infrastructure.common.constants.JwtConstants;
import com.duanxin.hwjy.infrastructure.common.exception.ResultEnum;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import com.duanxin.hwjy.infrastructure.util.SpringContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;

/**
 * @author duanxin
 * @version 1.0
 * @className LoginInterceptor
 * @date 2021/01/21 10:54
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestId = UUID.randomUUID().toString();
        try {
            log.info("verify whether the request [{}] is logged in", requestId);
            // fetch token & check
            JwtClientImpl jwtClient = SpringContext.getBean(JwtClientImpl.class);
            Map<String, Object> info = jwtClient.getInfoFromRequest(request);
            if (CollectionUtils.isEmpty(info)) {
                log.info("request [{}] is not logged in", requestId);
                responseJson(response, ResultEnum.USER_NOT_LOG_IN);
                return false;
            }

            log.info("request [{}] user [{}] is logged in", requestId, info.get(JwtConstants.USERID));
            return true;
        } catch (Exception exception) {
            log.warn("check the request [{}] is logged in exception", requestId, exception);
            responseJson(response, ResultEnum.VERIFY_USER_LOGGED_IN_EXCEPTION);
            return false;
        }
    }

    private void responseJson(HttpServletResponse response, ResultEnum resultEnum) throws Exception{
        response.setContentType("application/json,charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(JsonUtil.toString(ResponseResult.error(resultEnum.getCode(), resultEnum.getDesc())));
        writer.flush();
        writer.close();
    }
}
