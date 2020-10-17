package com.github.mrag.livechat.common.token;

import java.io.Serializable;

/**
 * @author Gmw
 */
public class TokenPayload implements Serializable {
    private static final long serialVersionUID = 1L;

    // 用户主键
    private long userId;
    // 密码编码后，密码一旦更改那么之前的token自然作废
    private String auth;
    // 该token签发者
    private String issuer;
    // 该token受众
    private String audience;
    // 该token签发时间毫秒值
    private long issuedAt;
    // 该token生效时间
    private long notBefore;
    // 该token过期时间
    private long expirationTime;

    // 默认过期时间为7天
    private static final long DEFAULT_TIMEOUT = 1000 * 60 * 60 * 24 * 7;

    public TokenPayload(long uid, String auth) {
        this(uid, auth, "All-Client");
    }

    // 提供默认无参构造函数以供JSON工具序列化使用
    public TokenPayload() {
    }

    public TokenPayload(long uid, String auth, String aud) {
        userId = uid;
        this.auth = auth;
        audience = aud;
        issuer = "mrag.io";
        issuedAt = System.currentTimeMillis();
        notBefore = issuedAt;
        expirationTime = DEFAULT_TIMEOUT + notBefore;
    }

    /**
     * @return 该token是否已过期
     */
    public boolean checkExpired() {
        return expirationTime <= System.currentTimeMillis();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public long getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(long issuedAt) {
        this.issuedAt = issuedAt;
    }

    public long getNotBefore() {
        return notBefore;
    }

    public void setNotBefore(long notBefore) {
        this.notBefore = notBefore;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getAuth() {
        return auth;
    }

    public TokenPayload setAuth(String auth) {
        this.auth = auth;
        return this;
    }
}
