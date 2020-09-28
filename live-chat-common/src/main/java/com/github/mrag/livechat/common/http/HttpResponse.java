package com.github.mrag.livechat.common.http;

import io.swagger.annotations.ApiModelProperty;

@Deprecated
public class HttpResponse {

    private enum HttpResponseCode {
        OK(1, "成功"),
        BAD_REQUEST(2, "错误请求"),
        WITHOUT_TOKEN(3, "访问权限控制"),
        INCORRECT_PASSWORD(4, "密码错误"),
        TOKEN_EXPIRED(5, "访问权限控制"),
        UNKNOWN(6, "系统未知错误");

        private final int code;
        private final String msg;

        HttpResponseCode(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }

    public static HttpResponse ok(Object body) {
        return new HttpResponse().code(HttpResponseCode.OK).setBody(body);
    }

    public static HttpResponse ok(Object body, String msg) {
        return new HttpResponse().code(HttpResponseCode.OK).setBody(body).setMessage(msg);
    }

    public static HttpResponse badRequest(String errorDetail) {
        return new HttpResponse().code(HttpResponseCode.BAD_REQUEST).setErrorDetail(errorDetail);
    }

    public static HttpResponse withoutToken(String errorDetail) {
        return new HttpResponse().code(HttpResponseCode.WITHOUT_TOKEN).setErrorDetail(errorDetail);
    }

    public static HttpResponse incorrectPassword(String errorDetail) {
        return new HttpResponse().code(HttpResponseCode.INCORRECT_PASSWORD).setErrorDetail(errorDetail);
    }

    public static HttpResponse tokenExpired(String errorDetail) {
        return new HttpResponse().code(HttpResponseCode.TOKEN_EXPIRED).setErrorDetail(errorDetail);
    }

    public static HttpResponse unknown(String errorDetail) {
        return new HttpResponse().code(HttpResponseCode.UNKNOWN).setErrorDetail(errorDetail);
    }

    @ApiModelProperty(value = "状态码")
    private int code;
    @ApiModelProperty(value = "状态信息")
    private String message;
    @ApiModelProperty(value = "返回体")
    private Object body;
    @ApiModelProperty(value = "错误信息")
    private String errorDetail;

    public HttpResponse code(HttpResponseCode code) {
        this.code = code.code;
        this.message = code.msg;
        return this;
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

    public String getErrorDetail() {
        return errorDetail;
    }

    public HttpResponse setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
        return this;
    }
}
