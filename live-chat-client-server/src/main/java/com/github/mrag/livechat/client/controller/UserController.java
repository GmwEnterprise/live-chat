package com.github.mrag.livechat.client.controller;

import com.github.mrag.livechat.common.HttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cli/user")
public class UserController {
    private final RestTemplate rest = new RestTemplate();

    @GetMapping("/{userId}")
    public HttpResponse findUserByUserId(@PathVariable("userId") Long userId) {
        return rest.getForObject("http://localhost:4200/api/v1/usermsg/{}",
                HttpResponse.class, userId);
    }

    @GetMapping("/phone/{phone}")
    public HttpResponse phoneExists(@PathVariable String phone) {
        throw new RuntimeException("haha");
        // return rest.getForObject("http://localhost:4200/api/v1/usermsg/phone/{}",
        //         HttpResponse.class, phone);
    }
}
