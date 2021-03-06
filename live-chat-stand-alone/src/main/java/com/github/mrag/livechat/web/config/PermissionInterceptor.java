package com.github.mrag.livechat.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(PermissionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) return true;

        // 打印请求信息
        log.debug("from[{}:{}]", request.getRemoteHost(), request.getRemotePort());
        log.debug("  request url[{}]", request.getRequestURI());

        // 权限判断
        boolean permission = ((HandlerMethod) handler).hasMethodAnnotation(Permission.class);
        if (permission) {
            String token = request.getHeader(HttpHeaders.AUTHORIZATION);
            Long userId = PermissionUtil.parseTokenReturnUserId(token);
            if (userId == null) {
                return false;
            }
            request.setAttribute("userId", userId);
        }
        return true;
    }
}
