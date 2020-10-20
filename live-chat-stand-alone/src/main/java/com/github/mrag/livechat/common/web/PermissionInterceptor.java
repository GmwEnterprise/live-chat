package com.github.mrag.livechat.common.web;

import org.springframework.http.HttpHeaders;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean permission = ((HandlerMethod) handler).hasMethodAnnotation(Permission.class);
        if (permission) {
            String token = request.getHeader(HttpHeaders.AUTHORIZATION);

            // TODO
        }
        return true;
    }
}
