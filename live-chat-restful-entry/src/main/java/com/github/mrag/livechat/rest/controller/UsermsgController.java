package com.github.mrag.livechat.rest.controller;

import com.github.mrag.livechat.common.Constants;
import com.github.mrag.livechat.usermsg.api.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usermsg")
public class UsermsgController {
    @DubboReference
    private UserService userService;
}
