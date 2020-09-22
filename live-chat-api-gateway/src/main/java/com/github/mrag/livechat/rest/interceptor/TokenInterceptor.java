package com.github.mrag.livechat.rest.interceptor;

import com.github.mrag.livechat.rest.AuthRequired;
import com.github.mrag.livechat.rest.HandlerInterceptorWithOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * Token校验拦截器，从请求头部获取token并验证
 *
 * @author Gmw
 */
public class TokenInterceptor implements HandlerInterceptorWithOrder {
    private static final Logger log = LoggerFactory.getLogger(TokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod controllerMethod = (HandlerMethod) handler;
            // 注解在 class 上
            boolean classHasAnnotation = controllerMethod.getBeanType().isAnnotationPresent(AuthRequired.class);
            // 注解在 method 上
            boolean methodHasAnnotation = controllerMethod.hasMethodAnnotation(AuthRequired.class);
            if (classHasAnnotation || methodHasAnnotation) {
                // TODO
            }
        }
        return true;
    }

    private void printRequest(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        List<String> headerList = new ArrayList<>();
        int maxHeaderSize = 0;
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            headerList.add(header);
            if (header.length() > maxHeaderSize) {
                maxHeaderSize = header.length();
            }
        }
        Collections.sort(headerList);
        StringBuilder headerTable = new StringBuilder("-----------------------------------\n");
        for (String headerName : headerList) {
            headerTable.append(String.format("%-" + maxHeaderSize + "s => %s%n",
                    headerName, request.getHeader(headerName)));
        }
        headerTable.append("-----------------------------------");
        log.info("\nRequest[{}] from [{}] headers: \n{}", request.getRequestURL(),
                request.getRemoteHost() + ":" + request.getRemotePort(), headerTable.toString());
    }
}
