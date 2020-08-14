package com.github.mrag.livechat.common.http;

public class HttpResponse {

    public static HttpResponse ok(Object body) {
        return new HttpResponse(HttpResponseCode.OK, body, null);
    }

    public static HttpResponse badRequest(String errorDesc) {
        return new HttpResponse(HttpResponseCode.BAD_REQUEST_ARGUMENT, null, errorDesc);
    }

    public static HttpResponse sysError(String errorDesc) {
        return new HttpResponse(HttpResponseCode.SYS_ERROR, null, errorDesc);
    }

    public static HttpResponse notFound(String errorDesc) {
        return new HttpResponse(HttpResponseCode.NOT_FOUND, null, errorDesc);
    }

    private int code;
    private String message;

    // ok

    private Object body;

    // fail

    private String errorDesc;

    public HttpResponse() {
    }

    public HttpResponse(HttpResponseCode httpResponseCode, String errorDesc) {
        this(httpResponseCode, null, errorDesc);
    }

    public HttpResponse(HttpResponseCode httpResponseCode, Object body, String errorDesc) {
        this.code = httpResponseCode.code;
        this.message = httpResponseCode.title;
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
