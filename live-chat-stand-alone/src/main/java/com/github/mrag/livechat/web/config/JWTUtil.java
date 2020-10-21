package com.github.mrag.livechat.web.config;

import com.github.mrag.livechat.common.ExceptionWrapper;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.Map;

public class JWTUtil implements ExceptionWrapper {
    /*
     * 参考：https://www.cnblogs.com/loveer/p/11429111.html
     */

    private static final String ISSUER = "Mrag.io";
    private static final String SECRET_KEY = "mrag.io";

    /**
     * 生成一个JWT
     *
     * @param claimsMap         payload
     * @param expirationSeconds 多少秒之后过期
     * @return JWT字符串
     */
    public static String generateJWT(Map<String, Object> claimsMap, long expirationSeconds) {
        JwtBuilder builder = Jwts.builder()
                .setIssuer(ISSUER)
                .setIssuedAt(new Date()) // 签发时间为现在
                .setExpiration(new Date(System.currentTimeMillis() + expirationSeconds * 1000)); // 过期时间
        claimsMap.forEach(builder::claim);
        return builder.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public static Claims parseJWT(String token) {
        try {
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            // 超时, 解析token失败
            return null;
        }
    }
}
