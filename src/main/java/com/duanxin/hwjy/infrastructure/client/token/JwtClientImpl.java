package com.duanxin.hwjy.infrastructure.client.token;

import com.duanxin.hwjy.infrastructure.common.constants.JwtConstants;
import com.duanxin.hwjy.infrastructure.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author duanxin
 * @version 1.0
 * @className JwtClientImpl
 * @date 2021/01/22 10:06
 */
@Service
@Slf4j
@AllArgsConstructor
public class JwtClientImpl implements JwtClient{

    private final JwtConfig jwtConfig;

    @Override
    public String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + jwtConfig.getExpireTime());
        return Jwts.builder().
                setClaims(claims).
                setExpiration(expirationDate).
                signWith(SignatureAlgorithm.HS512, JwtConstants.SECRET).
                compact();
    }

    @Override
    public String refreshToken(String token) {
        String newToken = null;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put(JwtConstants.CREATED, new Date());
            newToken = generateToken(claims);
        } catch (Exception exception) {
            log.warn("refresh token [{}] exception", token, exception);
        }
        return newToken;
    }

    @Override
    public Map<String, Object> getInfoFromToken(String token) {
        return getClaimsFromToken(token);
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser().
                    setSigningKey(JwtConstants.SECRET).
                    parseClaimsJws(token).
                    getBody();
        } catch (Exception exception) {
            log.warn("get claims from token [{}] exception", token, exception);
        }
        return claims;
    }
}
