package com.github.mrag.livechat.common;

/**
 * 业务异常
 *
 * @author Gmw
 */
public class BusinessException extends RuntimeException {

    public static BusinessException systemError(Throwable e) {
        BusinessException businessException = new BusinessException(ErrorType.SYSTEM_ERROR);
        businessException.addSuppressed(e);
        return businessException;
    }

    public static BusinessException withoutToken() {
        return new BusinessException(ErrorType.WITHOUT_TOKEN);
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

    public enum ErrorType {
        PASSWORD_WRONG("登陆失败，密码错误"),
        TOKEN_EXPIRED("登陆信息已失效，请重新登陆"),
        SYSTEM_ERROR("系统报错"),
        WITHOUT_TOKEN("访问权限控制");

        private final String msg;

        ErrorType(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }
}
