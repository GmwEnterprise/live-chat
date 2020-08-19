package com.github.mrag.livechat.rest.controller;

import com.github.mrag.livechat.common.http.HttpResponse;
import com.github.mrag.livechat.rest.OpenApi;
import com.github.mrag.livechat.usermsg.api.UserService;
import com.github.mrag.livechat.usermsg.dto.UserDTO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Gmw
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @DubboReference
    private UserService userService;

    /**
     * 通过主键获取用户信息
     *
     * @param userId 主键ID
     * @return 用户信息 or null
     */
    @GetMapping("/{userId}")
    public HttpResponse findUserByUserId(@PathVariable Long userId) {
        UserDTO user = userService.findUserById(userId);
        return user == null ? HttpResponse.notFound("系统无此用户") : HttpResponse.ok(user);
    }

    /**
     * 判断指定手机号是否存在
     *
     * @param phone 指定手机号
     * @return 是否存在
     */
    @GetMapping("/phone/{phone}/exists")
    @OpenApi
    public HttpResponse phoneExists(@PathVariable String phone) {
        boolean exists = userService.checkPhoneExists(phone);
        return HttpResponse.ok(exists);
    }

    /**
     * 注册新用户信息
     *
     * @param dto 新用户信息
     * @return 注册成功后的信息
     */
    @PostMapping
    @OpenApi
    public HttpResponse registry(@RequestBody @Valid UserDTO dto) {
        UserDTO afterSave = userService.save(dto);
        return HttpResponse.ok(afterSave);
    }

    @PostMapping("/testDTO")
    @OpenApi
    public HttpResponse testDTO(@RequestBody UserDTO dto) {
        System.out.println(dto);
        return HttpResponse.ok(null);
    }
}
