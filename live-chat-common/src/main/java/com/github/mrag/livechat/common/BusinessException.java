package com.github.mrag.livechat.common;

/**
 * 业务异常
 *
 * @author Gmw
 */
public class BusinessException extends RuntimeException {

    private ErrorType errorType;

    public BusinessException(ErrorType errorType) {
        super(errorType.msg);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public enum ErrorType {
        LOGIN_FAILED_PASSWORD_WRONG("登陆失败，密码错误");

        private final String msg;

        ErrorType(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }
}
