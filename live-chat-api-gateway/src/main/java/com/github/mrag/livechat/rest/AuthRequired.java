package com.github.mrag.livechat.rest;

import java.lang.annotation.*;

/**
 * 被此注解标记的controller或controller方法需要验证token
 *
 * @author Gmw
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthRequired {
}
