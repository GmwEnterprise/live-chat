package com.github.mrag.livechat.common.web;

import com.github.mrag.livechat.common.ExceptionWrapper;
import com.github.mrag.livechat.modules.user.entity.LivechatUser;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TokenUtil implements ExceptionWrapper {
    /*
     * 参考：https://www.cnblogs.com/loveer/p/11429111.html
     */

    private static final String ISSUER = "Mrag.io";
    private static final String SECRET_KEY = "mrag.io";
    private static final long VALID_TIME = 1000 * 60 * 60 * 24; // 1 days

    public String createToken(Map<String, Object> claimsMap) {
        JwtBuilder builder = Jwts.builder()
                .setIssuer(ISSUER)
                .setIssuedAt(new Date()) // 签发时间为现在
                .setExpiration(new Date(System.currentTimeMillis() + VALID_TIME)); // 过期时间
        claimsMap.forEach(builder::claim);
        return builder.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Claims parseToken(String token) {
        try {
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            // 超时, 解析token失败
            return null;
        }
    }

    public static void main(String[] args) {
        TokenUtil tokenUtil = new TokenUtil();
        LivechatUser user = new LivechatUser();
        user.setEmail("909498022@qq.com");
        String token = tokenUtil.createToken(Map.of(
                "userId", 12138L,
                "username", "Mrag",
                "entity", user
        ));
        tokenUtil.exp(() -> TimeUnit.SECONDS.sleep(3));
        System.out.println(tokenUtil.parseToken(token));
    }
}
