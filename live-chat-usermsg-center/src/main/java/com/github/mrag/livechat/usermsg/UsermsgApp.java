package com.github.mrag.livechat.usermsg;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(annotationClass = Mapper.class)
public class UsermsgApp {
    public static void main(String[] args) {
        SpringApplication.run(UsermsgApp.class, args);
    }
}
