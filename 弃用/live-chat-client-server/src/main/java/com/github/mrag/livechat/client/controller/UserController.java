package com.github.mrag.livechat.client.controller;

import com.github.mrag.livechat.client.LocalClientAppProperties;
import com.github.mrag.livechat.common.HttpResponse;
import com.github.mrag.livechat.usermsg.dto.ChatUsermsgDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gmw
 */
@RestController
@RequestMapping("/cli/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final RestTemplate rest = new RestTemplate();
    private final String httpPrefix;

    public UserController(LocalClientAppProperties properties) {
        httpPrefix = properties.getServerAddressPrefix();
    }

    @GetMapping("/{userId}")
    public HttpResponse findUserByUserId(@PathVariable("userId") Long userId) {
        // GET请求
        String url = httpPrefix + "/usermsg/{userId}";
        return rest.getForObject(url, HttpResponse.class, userId);
    }

    @GetMapping("/phone/{phone}")
    public HttpResponse phoneExists(@PathVariable String phone) {
        // GET 请求
        String url = httpPrefix + "/usermsg/phone/{phone}";
        return rest.getForObject(url, HttpResponse.class, phone);
    }

    @PostMapping
    public HttpResponse registry(@RequestBody ChatUsermsgDTO dto) {
        // 发送带有请求体的 POST 请求
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ChatUsermsgDTO> requestBody = new HttpEntity<>(dto, httpHeaders);
        String url = httpPrefix + "/usermsg";
        // return rest.postForObject(url, requestBody, HttpResponse.class);
        ResponseEntity<HttpResponse> entity = rest.postForEntity(url, requestBody, HttpResponse.class);
        log.debug("Entity.status = {}", entity.getStatusCode());
        return entity.getBody();
    }
}
