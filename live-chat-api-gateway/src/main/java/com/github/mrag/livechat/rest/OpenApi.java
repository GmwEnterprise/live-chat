package com.github.mrag.livechat.rest;

import java.lang.annotation.*;

/**
 * 开放式API
 * <p>
 * 被此注解标记的controller或controller方法无需验证token
 *
 * @author Gmw
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpenApi {
}
