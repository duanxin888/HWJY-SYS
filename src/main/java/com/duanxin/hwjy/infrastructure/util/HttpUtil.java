package com.duanxin.hwjy.infrastructure.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author duanxin
 * @version 1.0
 * @className HttpUtil
 * @date 2020/10/03 10:15
 */
public class HttpUtil {

    private HttpUtil() {
    }

    public static String getDataFromRequest(String key) {
        if (StringUtils.isBlank(key)) {
            return StringUtils.EMPTY;
        }
        HttpServletRequest request = request();
        String value = request.getHeader(key);
        if (StringUtils.isBlank(value)) {
            value = request.getParameter(key);
        }
        if (StringUtils.isBlank(value)) {
            value = com.duanxin.lsg.infrastructure.utils.CookieUtil.getCookie(request, key);
        }
        return value;
    }

    public static HttpServletRequest request() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public static HttpServletResponse response() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
    }
}
