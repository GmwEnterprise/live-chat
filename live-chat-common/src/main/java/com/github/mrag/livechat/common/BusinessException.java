package com.github.mrag.livechat.common;

/**
 * 业务异常
 *
 * @author Gmw
 */
public class BusinessException extends RuntimeException {

    public static BusinessException unknown() {
        return new BusinessException("unknown exception.").setCode(UNKNOWN);
    }

    public static BusinessException unknown(String msg) {
        return new BusinessException(msg).setCode(UNKNOWN);
    }

    public static BusinessException withoutToken() {
        return new BusinessException("missing token.").setCode(UNKNOWN);
    }

    public static BusinessException withoutToken(String msg) {
        return new BusinessException(msg).setCode(UNKNOWN);
    }

    public static BusinessException tokenExpired() {
        return new BusinessException("token expired.").setCode(UNKNOWN);
    }

    public static BusinessException tokenExpired(String msg) {
        return new BusinessException(msg).setCode(UNKNOWN);
    }

    public static BusinessException incorrectPassword() {
        return new BusinessException("incorrect password.").setCode(UNKNOWN);
    }

    public static BusinessException incorrectPassword(String msg) {
        return new BusinessException(msg).setCode(UNKNOWN);
    }

    public static final int UNKNOWN = 1;
    public static final int WITHOUT_TOKEN = 2;
    public static final int TOKEN_EXPIRED = 3;
    public static final int INCORRECT_PASSWORD = 4;

    private int code;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public BusinessException setCode(int code) {
        this.code = code;
        return this;
    }
}
