package com.duanxin.hwjy.api.aspect;

import com.duanxin.hwjy.infrastructure.common.exception.HWJYCheckException;
import com.duanxin.hwjy.infrastructure.util.HttpUtil;
import com.duanxin.hwjy.infrastructure.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author duanxin
 * @version 1.0
 * @className WebLogAspect
 * @date 2021/01/08 19:24
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

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
        String requestId = UUID.randomUUID().toString();
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
        }

        // response
        long endTime = System.currentTimeMillis();
        String r = JsonUtil.toString(res);
        log.info("response uri [{}] requestId [{}] spend [{}ms] method [{}] result [{}]",
                uri, requestId, (endTime - startTime), methodName, StringUtils.substring(r, 0, 2000));
        return res;
    }
}
