package com.kuraki.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EncryConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(EncryConfigApplication.class, args);
    }
}
