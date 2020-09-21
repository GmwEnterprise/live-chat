package com.github.mrag.livechat.rest.controller;

import com.github.mrag.livechat.common.http.HttpResponse;
import com.github.mrag.livechat.rest.OpenApi;
import com.github.mrag.livechat.usermsg.api.UserService;
import com.github.mrag.livechat.usermsg.vo.UserDetail;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息与用户关系接口
 *
 * @author Gmw
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @DubboReference
    private UserService userService;

    /**
     * 用户登陆
     */
    @PostMapping("/sign-in-user")
    @OpenApi
    HttpResponse signInUser(@RequestParam String phone, @RequestParam String password) {
        log.debug("用户登陆, phone = {}, password = {}", phone, password);
        String token = userService.signInUser(phone, password);
        return HttpResponse.ok(token, "登陆成功！");
    }

    /**
     * 用户注册
     */
    @PostMapping("/registry")
    @OpenApi
    HttpResponse registry(@RequestBody UserDetail detail) {
        log.debug("注册, msg = {}", detail);
        String token = userService.registry(detail);
        return HttpResponse.ok(token, "注册成功！");
    }

    /**
     * 修改个人信息
     */
    @PostMapping("/updateMsg")
    HttpResponse updateMsg(@RequestBody UserDetail detail) {
        log.debug("修改信息，id = {}, unmodified = {}", detail.getId(), detail);
        userService.modify(detail);
        return HttpResponse.ok(null, "个人信息修改成功！");
    }
}
