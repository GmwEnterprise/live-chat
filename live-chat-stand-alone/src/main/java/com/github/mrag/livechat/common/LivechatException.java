package com.github.mrag.livechat.common;

public class LivechatException extends RuntimeException {
    public static final String CODE_INTERNAL_ERROR = "1000";
    public static final String CODE_PERMISSION     = "1001";
    public static final String CODE_MISSING_DATA   = "1002";
    public static final String CODE_USER_NOT_FOUND = "1003";
    public static final String CODE_UNKNOWN        = "1004";

    private final LivechatExceptionResponse response;

    public LivechatException(String message) {
        super(message);
        response = new LivechatExceptionResponse().setCode(CODE_UNKNOWN).setMessage(message);
    }

    public LivechatException(String code, String message) {
        super(message);
        response = new LivechatExceptionResponse().setCode(code).setMessage(message);
    }

    public LivechatException(String message, Throwable cause) {
        super(message, cause);
        response = new LivechatExceptionResponse().setCode(CODE_UNKNOWN).setMessage(message);
    }

    public LivechatException(Throwable cause) {
        super(cause);
        response = new LivechatExceptionResponse().setCode(CODE_UNKNOWN).setMessage(cause.getMessage());
    }

    public LivechatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        response = new LivechatExceptionResponse().setCode(CODE_UNKNOWN).setMessage(cause.getMessage());
    }

    public LivechatExceptionResponse getResponse() {
        return response;
    }

    private static class LivechatExceptionResponse {
        private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public LivechatExceptionResponse setCode(String code) {
            this.code = code;
            return this;
        }

        public String getMessage() {
            return message;
        }

        public LivechatExceptionResponse setMessage(String message) {
            this.message = message;
            return this;
        }
    }
}
