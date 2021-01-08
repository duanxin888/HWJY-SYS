package com.duanxin.hwjy.infrastructure.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author duanxin
 * @version 1.0
 * @className CookieUtil
 * @date 2020/10/03 10:19
 */
public class CookieUtil {

    private CookieUtil() {

    }

    public static String getCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            return StringUtils.EMPTY;
        }
        String value = StringUtils.EMPTY;
        for (Cookie cookie : cookies) {
            if (key.equalsIgnoreCase(cookie.getName())) {
                value = cookie.getValue();
                break;
            }
        }
        return value;
    }
}
