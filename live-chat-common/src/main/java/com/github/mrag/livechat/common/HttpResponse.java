package com.github.mrag.livechat.common;

public class HttpResponse {

    public static final int CODE_OK = 0;
    public static final int CODE_SYS_ERROR = 100;
    public static final int CODE_DATA_NOT_FOUND = 200;

    public static final String MSG_OK = "OK";
    public static final String MSG_FAIL = "FAIL";

    public static HttpResponse ok(Object body) {
        return new HttpResponse(CODE_OK, MSG_OK, body, null);
    }

    public static HttpResponse sysError(String errorDesc) {
        return new HttpResponse(CODE_SYS_ERROR, MSG_FAIL, null, errorDesc);
    }

    public static HttpResponse notFound(String errorDesc) {
        return new HttpResponse(CODE_DATA_NOT_FOUND, MSG_FAIL, null, errorDesc);
    }

    private int code;
    private String message;

    // ok

    private Object body;

    // fail

    private String errorDesc;

    public HttpResponse() {
    }

    public HttpResponse(int code, String message, Object body, String errorDesc) {
        this.code = code;
        this.message = message;
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
