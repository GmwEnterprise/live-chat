package com.github.mrag.livechat.usermsg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Gmw
 */
@SpringBootApplication
@MapperScan(basePackages = "com.github.mrag.livechat.usermsg.dao")
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }
}
