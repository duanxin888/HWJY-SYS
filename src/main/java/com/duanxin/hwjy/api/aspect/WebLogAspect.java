package com.duanxin.hwjy.api.aspect;

import com.duanxin.hwjy.infrastructure.client.context.ContextClient;
import com.duanxin.hwjy.infrastructure.common.constants.Constants;
import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.util.HttpUtil;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author duanxin
 * @version 1.0
 * @className WebLogAspect
 * @date 2021/01/08 19:24
 */
@Aspect
@Component
@Slf4j
@AllArgsConstructor
public class WebLogAspect {

    private final ContextClient contextClient;

    @Pointcut("execution(public * com.duanxin.hwjy.*.facade.*.*(..))")
    public void log() {
        // do nothing
    }

    @Around("log()")
    public Object doLog(ProceedingJoinPoint point) throws Throwable{
        // request
        long startTime = System.currentTimeMillis();
        HttpServletRequest request = HttpUtil.request();
        String uri = request.getRequestURI();
        String args = JsonUtil.toString(Arrays.asList(point.getArgs()));
        String methodName = point.getSignature().getName();
        String requestIdKey = Constants.REQUEST_ID.getDesc();
        String requestId = contextClient.get(requestIdKey);
        log.info("request uri [{}] requestId [{}] method [{}] args {}",
                uri, requestId, methodName, args);

        // process
        Object res = null;
        try {
            res = point.proceed();
        } catch (HWJYCheckException exception) {
            log.warn("request uri [{}] requestId [{}] method [{}] args {} exception",
                    uri, requestId, methodName, args, exception);
            throw exception;
        } catch (Exception exception) {
            log.error("request uri [{}] requestId [{}] method [{}] args {} exception",
                    uri, requestId, methodName, args, exception);
            throw exception;
        } finally {
            contextClient.remove(requestIdKey);
        }

        // response
        long endTime = System.currentTimeMillis();
        String r = JsonUtil.toString(res);
        log.info("response uri [{}] requestId [{}] spend [{}ms] method [{}] result [{}]",
                uri, requestId, (endTime - startTime), methodName, StringUtils.substring(r, 0, 2000));
        contextClient.remove(requestIdKey);
        return res;
    }
}
