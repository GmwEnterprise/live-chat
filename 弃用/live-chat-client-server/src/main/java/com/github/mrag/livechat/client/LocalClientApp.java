package com.github.mrag.livechat.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalClientApp {
    public static final boolean IS_DEV = true;

    public static void main(String[] args) {
        SpringApplication.run(LocalClientApp.class, args);
    }
}
