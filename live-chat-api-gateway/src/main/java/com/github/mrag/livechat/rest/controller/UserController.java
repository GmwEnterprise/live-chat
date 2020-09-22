package com.github.mrag.livechat.rest.controller;

import com.github.mrag.livechat.common.constant.enums.AccountStatus;
import com.github.mrag.livechat.common.constant.enums.BloodGroup;
import com.github.mrag.livechat.common.constant.enums.Gender;
import com.github.mrag.livechat.common.http.HttpResponse;
import com.github.mrag.livechat.rest.AuthRequired;
import com.github.mrag.livechat.usermsg.api.UserService;
import com.github.mrag.livechat.usermsg.vo.UserDetail;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 用户信息与用户关系接口
 *
 * @author Gmw
 */
@Api(tags = "用户信息与用户关系接口")
@RestController
@RequestMapping("/user")
// @AuthRequired
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @DubboReference
    private UserService userService;

    // @ApiOperation("用户登陆")
    @PostMapping("/sign-in-user")
    HttpResponse signInUser(/*@ApiParam(value = "手机号码/微信号/邮箱", required = true)*/
            @RequestParam
                    String key,
            /*@ApiParam(value = "密码，需加密处理", required = true)*/
            @RequestParam
                    String password) {
        log.debug("用户登陆, key = {}, password = {}", key, password);
        // TODO 修改登陆函数，使其支持三种key的登陆
        String token = userService.signInUser(key, password);
        return HttpResponse.ok(token, "登陆成功！");
    }

    // @ApiOperation("用户注册")
    @PostMapping("/registry")
    HttpResponse registry(@RequestBody UserDetail detail) {
        log.debug("注册, msg = {}", detail);
        String token = userService.registry(detail);
        return HttpResponse.ok(token, "注册成功！");
    }

    // @ApiOperation("修改个人信息")
    @PostMapping("/updateMsg")
    HttpResponse updateMsg(@RequestBody UserDetail detail) {
        log.debug("修改信息，id = {}, unmodified = {}", detail.getId(), detail);
        userService.modify(detail);
        return HttpResponse.ok(null, "个人信息修改成功！");
    }

    // @ApiOperation("测试接口")
    @GetMapping("/test")
    // @AuthRequired
    HttpResponse testInterface(@RequestParam(required = false) Gender gender,
                               @RequestParam(required = false) BloodGroup bloodGroup,
                               @RequestParam(required = false) AccountStatus accountStatus,
                               @RequestParam(required = false) LocalDateTime date) {
        return HttpResponse.ok(Map.of(
                "gender", gender,
                "bloodGroup", bloodGroup,
                "accountStatus", accountStatus,
                "date", date));
    }
}
