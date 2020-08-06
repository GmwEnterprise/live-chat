package com.github.mrag.livechat.rest.controller;

import com.github.mrag.livechat.common.HttpResponse;
import com.github.mrag.livechat.usermsg.api.UserService;
import com.github.mrag.livechat.usermsg.dto.ChatUsermsgDTO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/usermsg")
public class UsermsgController {
    @DubboReference
    private UserService userService;

    @GetMapping("/{userId}")
    public HttpResponse findUserByUserId(@PathVariable Long userId) {
        ChatUsermsgDTO user = userService.findUserById(userId);
        return user == null ? HttpResponse.notFound("系统无此用户")
                : HttpResponse.ok(user);
    }

    @GetMapping("/phone/{phone}")
    public HttpResponse phoneExists(@PathVariable String phone) {
        boolean exists = userService.checkPhoneExists(phone);
        return HttpResponse.ok(exists);
    }

    @PostMapping
    public HttpResponse registry(@RequestBody @Valid ChatUsermsgDTO dto) {
        userService.save(dto);
        return HttpResponse.ok(null);
    }
}
