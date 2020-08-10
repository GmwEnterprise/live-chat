package com.github.mrag.livechat.common;

/**
 * 正则表达式汇总
 *
 * @author Gmw
 */
public interface RegExp {
    // JS密码正则校验：const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$/

    // 手机号码校验
    String REGEXP_PHONE = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
    String REGEXP_PHONE_MSG = "手机号码格式错误";

    // 用户名校验
    String REGEXP_USERNAME = "^[\\u4E00-\\u9FA5A-Za-z0-9_]+$";
    String REGEXP_USERNAME_MSG = "用户名仅支持中文、数字、字母、下划线";

    // ID校验
    String REGEXP_ID = "^[A-Za-z0-9]+$";
    String REGEXP_ID_MSG = "ID仅可包含字母与数字";
}
