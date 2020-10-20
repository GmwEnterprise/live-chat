package com.github.mrag.livechat.common;

public class LivechatException extends RuntimeException {
    public static final String CODE_INTERNAL_ERROR = "1000";
    public static final String CODE_PERMISSION = "1001";
    public static final String CODE_MISSING_DATA = "1002";
    private static final String CODE_UNKNOWN = "1002";

    private final LivechatExceptionResponse response;

    public LivechatException(String message) {
        super(message);
        response = new LivechatExceptionResponse().setErrorCode(CODE_UNKNOWN).setErrorMessage(message);
    }

    public LivechatException(String code, String message) {
        super(message);
        response = new LivechatExceptionResponse().setErrorCode(code).setErrorMessage(message);
    }

    public LivechatException(String message, Throwable cause) {
        super(message, cause);
        response = new LivechatExceptionResponse().setErrorCode(CODE_UNKNOWN).setErrorMessage(message);
    }

    public LivechatException(Throwable cause) {
        super(cause);
        response = new LivechatExceptionResponse().setErrorCode(CODE_UNKNOWN).setErrorMessage(cause.getMessage());
    }

    public LivechatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        response = new LivechatExceptionResponse().setErrorCode(CODE_UNKNOWN).setErrorMessage(cause.getMessage());
    }

    public LivechatExceptionResponse getResponse() {
        return response;
    }

    public static class LivechatExceptionResponse {
        private String errorCode;
        private String errorMessage;

        public String getErrorCode() {
            return errorCode;
        }

        public LivechatExceptionResponse setErrorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public LivechatExceptionResponse setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }
    }
}
