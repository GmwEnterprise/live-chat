package com.github.mrag.livechat.common.http;

/**
 * @author Gmw
 */

public enum HttpResponseCode {
    // ok
    OK(0, "OK"),

    // 系统异常
    UNKNOWN(500, "位置系统错误"),

    // 相关资源未找到
    NOT_FOUND(404, "未找到该资源"),

    // 请求参数校验错误
    BAD_REQUEST_ARGUMENT(400, "参数校验失败"),

    // 凭据过期
    CREDENTIALS_EXPIRED(5, "登陆凭据失效"),

    // 密码错误
    PASSWORD_WRONG(6, "输入密码错误"),

    // 需要token
    WITHOUT_TOKEN(7, "请登录后访问");

    private final int code;
    private final String title;

    HttpResponseCode(int code, String title) {
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
