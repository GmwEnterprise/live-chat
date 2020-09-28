package com.github.mrag.livechat.rest.interceptor;

import com.github.mrag.livechat.common.ApiException;
import com.github.mrag.livechat.common.token.TokenPayload;
import com.github.mrag.livechat.common.token.TokenUtil;
import com.github.mrag.livechat.common.utils.SpringContextUtils;
import com.github.mrag.livechat.rest.AuthRequired;
import com.github.mrag.livechat.rest.RestConsumer;
import com.github.mrag.livechat.usermsg.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

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
public class TokenInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(TokenInterceptor.class);

    private UserService userService = null;
    private final Object lock = new Object();

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod controllerMethod = (HandlerMethod) handler;
            // 权限注解在 class 上
            boolean classHasAnnotation = controllerMethod.getBeanType().isAnnotationPresent(AuthRequired.class);
            // 权限注解在 method 上
            boolean methodHasAnnotation = controllerMethod.hasMethodAnnotation(AuthRequired.class);
            if (classHasAnnotation || methodHasAnnotation) {
                // 验证token
                String tokenVal = request.getHeader("authentication");
                TokenPayload payload;
                try {
                    payload = TokenUtil.parseToken(tokenVal, TokenPayload.class);
                } catch (Exception e) {
                    // 解析错误，可能是token被污染
                    throw ApiException.withoutToken("请携带正确的token");
                }
                if (payload.checkExpired()) {
                    // 已过期
                    throw ApiException.tokenExpired();
                }
                if (userService == null) {
                    synchronized (lock) {
                        if (userService == null) {
                            userService = SpringContextUtils.getBean(RestConsumer.class).getUserService();
                        }
                    }
                }
                if (userService.findUserHashById(payload.getUserId()).equals(payload.getAuth())) {
                    // 密码未修改
                    return true;
                }
                throw ApiException.withoutToken("请重新获取token");
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
