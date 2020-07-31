package com.github.mrag.livechat.rest.controller;

import com.github.mrag.livechat.rest.base.HttpResp;
import com.github.mrag.livechat.usermsg.api.UserService;
import com.github.mrag.livechat.usermsg.dto.ChatUsermsgDTO;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usermsg")
public class UsermsgController {
    @DubboReference
    private UserService userService;

    @GetMapping("/{userId}")
    public HttpResp<ChatUsermsgDTO> findUserByUserId(@PathVariable Long userId) {
        ChatUsermsgDTO user = userService.findUserById(userId);
        HttpResp<ChatUsermsgDTO> dto = new HttpResp<>();
        dto.setBody(user);
        dto.setCode(0);
        dto.setMessage("ok");
        return dto;
    }
}
