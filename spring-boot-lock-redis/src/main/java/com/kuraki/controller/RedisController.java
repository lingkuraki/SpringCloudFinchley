package com.kuraki.controller;

import com.kuraki.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/test")
    public void test() throws InterruptedException {
        redisService.test();
    }

}
