package com.github.mrag.livechat.web.config;

import io.jsonwebtoken.Claims;

import java.util.Map;

public class PermissionUtil {

    public static String createTokenWithUserId(Long userId) {
        Map<String, Object> userMap = Map.of("id", userId);
        return JWTUtil.generateJWT(userMap, 60 * 60 * 2);
    }

    public static Long parseTokenReturnUserId(String token) {
        Claims claims = JWTUtil.parseJWT(token);
        if (claims == null) return null;
        return ((Long) claims.get("id"));
    }
}
