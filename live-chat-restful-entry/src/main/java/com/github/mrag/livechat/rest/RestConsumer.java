package com.github.mrag.livechat.rest;

import com.github.mrag.livechat.usermsg.api.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

@Component
public class RestConsumer {

    @DubboReference
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }
}
