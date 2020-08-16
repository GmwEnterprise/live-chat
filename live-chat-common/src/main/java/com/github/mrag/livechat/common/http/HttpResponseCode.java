package com.github.mrag.livechat.common.http;

/**
 * @author Gmw
 */

public enum HttpResponseCode {
    // ok
    OK(0, "OK"),

    // 系统异常
    SYS_ERROR(500, "System error"),

    // 相关资源未找到
    NOT_FOUND(404, "Not found"),

    // 请求参数校验错误
    BAD_REQUEST_ARGUMENT(400, "Bad request argument"),

    // 凭据过期
    CREDENTIALS_EXPIRED(5, "登陆凭据已失效"),

    // 密码错误
    PASSWORD_WRONG(6, "密码错误"),

    // 需要token
    WITHOUT_TOKEN(7, "访问权限控制");

    final int code;
    final String title;

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
