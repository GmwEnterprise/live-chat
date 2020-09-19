package com.github.mrag.livechat.rest.controller;

import com.github.mrag.livechat.common.http.HttpResponse;
import com.github.mrag.livechat.usermsg.api.UserService;
import com.github.mrag.livechat.usermsg.vo.UserDetail;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息与用户关系接口
 *
 * @author Gmw
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @DubboReference
    private UserService userService;

    @GetMapping("/registry")
    HttpResponse registry(@RequestBody UserDetail userDetail) {

        return HttpResponse.ok(null);
    }
}
