package com.github.mrag.livechat.client.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.http.HttpClient;

@Service
public class HttpClientService {

    private final HttpClient http = HttpClient.newHttpClient();

    @PostConstruct
    public void initialize() {
        // 初始化 http 客户端
    }
}
