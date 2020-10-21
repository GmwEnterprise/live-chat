package com.github.mrag.livechat.web;

import com.github.mrag.livechat.modules.user.dto.LivechatUserRegistration;
import com.github.mrag.livechat.modules.user.entity.LivechatUser;
import com.github.mrag.livechat.modules.user.service.UserService;
import com.github.mrag.livechat.web.config.BaseRestController;
import com.github.mrag.livechat.web.config.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ResponseHeader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api
@RestController
@RequestMapping("/user")
public class UserController implements BaseRestController {
    @Resource
    private UserService userService;

    @ApiOperation("注册")
    @ResponseHeader(
            name = HttpHeaders.AUTHORIZATION,
            description = "用于校验身份的token，注册或登陆成功后返回",
            response = String.class)
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody @Valid LivechatUserRegistration registrationMsg) {
        // 响应头中设置token
        String token = userService.signUp(registrationMsg);
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, token).build();
    }

    @ApiOperation("密码登陆")
    @ResponseHeader(
            name = HttpHeaders.AUTHORIZATION,
            description = "用于校验身份的token，注册或登陆成功后返回",
            response = String.class)
    @PostMapping("/sign-in/{verificationText}")
    public ResponseEntity<?> signIn(@ApiParam @PathVariable String verificationText) {
        String token = userService.signIn(verificationText);
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, token).build();
    }

    @ApiOperation("个人信息获取")
    @GetMapping("/my-msg")
    @Permission
    public ResponseEntity<LivechatUser> myMessage(@RequestAttribute("userId") Long userId) {
        LivechatUser user = userService.findByUserId(userId);
        return ResponseEntity.ok(user);
    }
}
