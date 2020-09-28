package com.github.mrag.livechat.common;

/**
 * 业务异常
 *
 * @author Gmw
 */
public class ApiException extends RuntimeException {
    public static ApiException unexpectedParameters(String errorMsg) {
        return new ApiException("入参错误: " + errorMsg).setCode(UNEXPECTED_PARAMETERS);
    }

    public static ApiException unknown() {
        return new ApiException("未知异常.").setCode(UNKNOWN);
    }

    public static ApiException unknown(String msg) {
        return new ApiException(msg).setCode(UNKNOWN);
    }

    public static ApiException withoutToken() {
        return new ApiException("您未获取到访问权限.").setCode(WITHOUT_TOKEN);
    }

    public static ApiException withoutToken(String msg) {
        return new ApiException(msg).setCode(WITHOUT_TOKEN);
    }

    public static ApiException tokenExpired() {
        return new ApiException("权限失效，请重新获取.").setCode(TOKEN_EXPIRED);
    }

    public static ApiException tokenExpired(String msg) {
        return new ApiException(msg).setCode(TOKEN_EXPIRED);
    }

    public static ApiException incorrectPassword() {
        return new ApiException("密码错误.").setCode(INCORRECT_PASSWORD);
    }

    public static ApiException incorrectPassword(String msg) {
        return new ApiException(msg).setCode(INCORRECT_PASSWORD);
    }

    public static final int UNKNOWN = 1;
    public static final int WITHOUT_TOKEN = 2;
    public static final int TOKEN_EXPIRED = 3;
    public static final int INCORRECT_PASSWORD = 4;
    public static final int UNEXPECTED_PARAMETERS = 5;

    private int code;

    public ApiException() {
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public ApiException setCode(int code) {
        this.code = code;
        return this;
    }
}
