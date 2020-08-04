package com.github.mrag.livechat.client.controller;

public class HttpResp<E> {
    private int code;
    private String message;
    private E body;

    public HttpResp() {
    }

    public HttpResp(E body) {
        this.code = 0;
        this.message = "ok";
        this.body = body;
    }

    public HttpResp(int code, String message, E body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public HttpResp<E> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public HttpResp<E> setMessage(String message) {
        this.message = message;
        return this;
    }

    public E getBody() {
        return body;
    }

    public HttpResp<E> setBody(E body) {
        this.body = body;
        return this;
    }
}
