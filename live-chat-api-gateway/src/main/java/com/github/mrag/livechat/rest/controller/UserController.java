package com.github.mrag.livechat.rest.controller;

import com.github.mrag.livechat.common.http.HttpResponse;
import com.github.mrag.livechat.rest.OpenApi;
import com.github.mrag.livechat.usermsg.api.UserService;
import com.github.mrag.livechat.usermsg.dto.UserDTO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    /**
     * 通过主键获取用户信息
     *
     * @param userId 主键ID
     * @return 用户信息 or null
     */
    @GetMapping("/{userId}")
    public HttpResponse findUserByUserId(@PathVariable Long userId) {
        UserDTO user = userService.findUserById(userId);
        return HttpResponse.ok(user);
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
     * @return token
     */
    @PostMapping
    @OpenApi
    public HttpResponse registry(@RequestBody @Valid UserDTO dto) {
        String token = userService.registry(dto);
        return HttpResponse.ok(token);
    }

    /**
     * 登录
     *
     * @param dto .phone=手机号，.password=密码
     * @return token
     */
    @PostMapping("/login")
    @OpenApi
    public HttpResponse testDTO(@RequestBody @Valid UserDTO dto) {
        String phone = dto.getPhoneNumber(),
                password = dto.getUserPassword();
        return HttpResponse.ok(userService.login(phone, password));
    }
}
