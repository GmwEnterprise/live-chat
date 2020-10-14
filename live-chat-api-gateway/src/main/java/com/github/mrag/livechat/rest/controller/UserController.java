package com.github.mrag.livechat.rest.controller;

import com.github.mrag.livechat.common.constant.enums.AccountStatus;
import com.github.mrag.livechat.common.constant.enums.BloodGroup;
import com.github.mrag.livechat.common.constant.enums.Gender;
import com.github.mrag.livechat.rest.Permission;
import com.github.mrag.livechat.usermsg.api.UserService;
import com.github.mrag.livechat.usermsg.vo.UserDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @DubboReference
    private UserService userService;

    @ApiOperation("用户登陆")
    @PostMapping("/sign-in-user")
    ResponseEntity<?> signInUser(@ApiParam(value = "手机号码/微信号/邮箱", required = true)
                                 @RequestParam String key,
                                 @ApiParam(value = "密码，需解密", required = true)
                                 @RequestParam String password) {
        String token = userService.signInUser(key, password);
        HttpHeaders headers = new HttpHeaders();
        headers.add("authentication", token);
        return ResponseEntity.ok().headers(headers).build();
    }

    @ApiOperation("用户注册")
    @PostMapping("/registry")
    ResponseEntity<?> registry(@ApiParam(value = "注册信息", required = true)
                               @RequestBody UserDetail detail) {
        log.debug("注册, msg = {}", detail);
        String token = userService.registry(detail);
        HttpHeaders headers = new HttpHeaders();
        headers.add("authentication", token);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }

    @ApiOperation("修改个人信息")
    @PostMapping("/update-msg")
    @Permission
    ResponseEntity<?> updateMsg(@ApiParam(value = "需要修改的信息", required = true)
                                @RequestBody UserDetail detail) {
        log.debug("修改信息，id = {}, unmodified = {}", detail.getId(), detail);
        userService.modify(detail);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("测试接口")
    @GetMapping("/test")
    ResponseEntity<?> testInterface(@RequestParam(required = false) Gender gender,
                                    @RequestParam(required = false) BloodGroup bloodGroup,
                                    @RequestParam(required = false) AccountStatus accountStatus,
                                    @RequestParam(required = false) LocalDateTime date) {
        return ResponseEntity.ok(Map.of(
                "gender", gender,
                "bloodGroup", bloodGroup,
                "accountStatus", accountStatus,
                "date", date));
    }
}
