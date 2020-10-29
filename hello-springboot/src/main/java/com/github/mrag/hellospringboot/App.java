package com.github.mrag.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootApplication这个注解是三个注解的语法糖：
 * SpringBootConfiguration，EnableAutoConfiguration、ComponentScan
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
