package com.duanxin.hwjy.infrastructure.client.token;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author duanxin
 * @version 1.0
 * @className JwtClient
 * @date 2021/01/22 10:06
 */
public interface JwtClient {

    /**
     * generate token with claims {@link Map}
     * @param claims set key from {@link com.duanxin.hwjy.infrastructure.common.constants.JwtConstants}
     * @date 2021/1/22 10:44
     * @return java.lang.String
     */
    String generateToken(Map<String, Object> claims);

    String refreshToken(String token);

    /**
     * get user info from token
     * @date 2021/1/22 10:44
     * @return java.util.Map<java.lang.String,java.lang.Object>
     *     get key from {@link com.duanxin.hwjy.infrastructure.common.constants.JwtConstants}
     */
    Map<String, Object> getInfoFromRequest(HttpServletRequest request);
}
