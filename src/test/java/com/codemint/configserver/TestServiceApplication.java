package com.codemint.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(ConfigServerApplication::main)
                .with(TestServiceApplication.class)
                .run(args);
    }
}
