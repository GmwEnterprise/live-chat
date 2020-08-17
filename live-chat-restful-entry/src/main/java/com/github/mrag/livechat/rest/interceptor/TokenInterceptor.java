package com.github.mrag.livechat.rest.interceptor;

import com.github.mrag.livechat.common.BusinessException;
import com.github.mrag.livechat.common.token.TokenPayload;
import com.github.mrag.livechat.common.token.TokenUtil;
import com.github.mrag.livechat.common.utils.SpringContextUtils;
import com.github.mrag.livechat.common.utils.Tools;
import com.github.mrag.livechat.rest.HandlerInterceptorWithOrder;
import com.github.mrag.livechat.rest.OpenApi;
import com.github.mrag.livechat.usermsg.api.UserService;
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
        // 打印请求信息 测试need
        printRequest(request);
        Tools.printInputStream(request.getInputStream());

        // 判断是否为OpenApi
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        boolean methodIsOpen = handlerMethod.hasMethodAnnotation(OpenApi.class);
        boolean controllerIsOpen = handlerMethod.getBeanType().isAnnotationPresent(OpenApi.class);
        if (methodIsOpen || controllerIsOpen) {
            // 是
            return true;
        }
        String authorization = request.getHeader("authorization");
        if (authorization == null) {
            // 没有token，访问失败
            throw BusinessException.withoutToken();
        }

        // token应该为系统所提供的jwt字符串
        // 会抛出解析异常，解析失败就直接返回false并记录日志
        TokenPayload payload;
        try {
            payload = TokenUtil.parseToken(authorization, TokenPayload.class);
        } catch (Exception parsingError) {
            log.info("token校验时产生解析异常.", parsingError);
            return false;
        }
        // 校验payload
        if (payload.checkExpired()) {
            throw new BusinessException(BusinessException.ErrorType.TOKEN_EXPIRED);
        }

        // TODO 密码是否修改
        long userId = payload.getUserId();
        // 获取不到bean，空指针异常 TODO
        UserService userService = SpringContextUtils.getBean(UserService.class);
        System.out.println(">>> userService is " + userService);
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
