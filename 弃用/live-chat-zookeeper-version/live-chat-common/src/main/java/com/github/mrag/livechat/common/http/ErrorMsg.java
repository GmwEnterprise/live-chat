package com.github.mrag.livechat.common.http;

/**
 * 服务器出现错误时，封装的错误信息
 */
public class ErrorMsg {
    private int errorCode;
    private String detail;

    public ErrorMsg(int errorCode, String detail) {
        this.errorCode = errorCode;
        this.detail = detail;
    }

    public ErrorMsg() {
    }

    public int getErrorCode() {
        return errorCode;
    }

    public ErrorMsg setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public ErrorMsg setDetail(String detail) {
        this.detail = detail;
        return this;
    }
}
