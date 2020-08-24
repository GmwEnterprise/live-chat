package com.github.mrag.livechat.common;

/**
 * 业务异常
 *
 * @author Gmw
 */
public class BusinessException extends RuntimeException {

    public static BusinessException unknown() {
        return new BusinessException(ErrorType.UNKNOWN);
    }

    public static BusinessException withoutToken() {
        return new BusinessException(ErrorType.WITHOUT_TOKEN);
    }

    public static BusinessException incorrectPassword() {
        return new BusinessException(ErrorType.INCORRECT_PASSWORD);
    }

    // 成员

    public enum ErrorType {
        INCORRECT_PASSWORD("登陆失败，密码错误"),
        TOKEN_EXPIRED("登陆信息已失效，请重新登陆"),
        WITHOUT_TOKEN("访问权限控制"),
        UNKNOWN("未知系统错误");

        private final String msg;

        ErrorType(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }

    private ErrorType errorType;

    public BusinessException(ErrorType errorType) {
        super(errorType.msg);
        this.errorType = errorType;
    }

    public BusinessException(ErrorType errorType, String detail) {
        super(detail);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }
}
