package com.github.mrag.livechat.web.config;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {

    /**
     * 角色 TODO
     */
    String role() default "";
}
