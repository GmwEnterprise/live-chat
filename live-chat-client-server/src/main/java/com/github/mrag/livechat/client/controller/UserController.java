package com.github.mrag.livechat.client.controller;

import com.github.mrag.livechat.usermsg.api.UserService;
import com.github.mrag.livechat.usermsg.dto.ChatUsermsgDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/cli/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/{userId}")
    public HttpResp<ChatUsermsgDTO> findUserByUserId(@PathVariable("userId") Long userId) {
        return new HttpResp<>(userService.findUserById(userId));
    }

    @GetMapping("/phone/{phone}")
    public HttpResp<Boolean> phoneExists(@PathVariable String phone) {
        return new HttpResp<>(userService.checkPhoneExists(phone));
    }
}
