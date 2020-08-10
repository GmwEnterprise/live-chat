package com.github.mrag.livechat.common;

public class HttpResponse {

    public enum ResponseCode {
        OK(0, "OK"),
        SYS_ERROR(100, "System error"),
        NOT_FOUND(404, "Not found"),
        BAD_REQUEST_ARGUMENT(400, "Bad request argument");

        private final int code;
        private final String title;

        ResponseCode(int code, String title) {
            this.code = code;
            this.title = title;
        }

        public int getCode() {
            return code;
        }

        public String getTitle() {
            return title;
        }
    }

    public static HttpResponse ok(Object body) {
        return new HttpResponse(ResponseCode.OK, body, null);
    }

    public static HttpResponse badRequest(String errorDesc) {
        return new HttpResponse(ResponseCode.BAD_REQUEST_ARGUMENT, null, errorDesc);
    }

    public static HttpResponse sysError(String errorDesc) {
        return new HttpResponse(ResponseCode.SYS_ERROR, null, errorDesc);
    }

    public static HttpResponse notFound(String errorDesc) {
        return new HttpResponse(ResponseCode.NOT_FOUND, null, errorDesc);
    }

    private int code;
    private String message;

    // ok

    private Object body;

    // fail

    private String errorDesc;

    public HttpResponse() {
    }

    public HttpResponse(ResponseCode responseCode, Object body, String errorDesc) {
        this.code = responseCode.code;
        this.message = responseCode.title;
        this.body = body;
        this.errorDesc = errorDesc;
    }

    public int getCode() {
        return code;
    }

    public HttpResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public HttpResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getBody() {
        return body;
    }

    public HttpResponse setBody(Object body) {
        this.body = body;
        return this;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public HttpResponse setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
        return this;
    }
}
