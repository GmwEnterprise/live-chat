package com.github.mrag.livechat.rest;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author Gmw
 */
public interface HandlerInterceptorWithOrder extends HandlerInterceptor {

    /**
     * 提供该拦截器的order，默认为常规优先级
     *
     * @return orderValue
     */
    default int order() {
        return ORDER_NORMAL;
    }

    int ORDER_NORMAL = 5;
    int ORDER_FIRST = 0;
    int ORDER_LAST = 10;
}
