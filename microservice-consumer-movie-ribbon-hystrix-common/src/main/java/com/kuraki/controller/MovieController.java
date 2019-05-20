package com.kuraki.controller;

import com.kuraki.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RequestMapping("/movies")
@RestController
@Slf4j
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        User user = restTemplate.getForObject("http://microservice-provider-user/users/{id}", User.class, id);
        return user;
    }

    public User findByIdFallback(Long id, Throwable e) {
        log.error("进入回退方法", e);
        return new User(id, "kuraki", "地表最强", 22, new BigDecimal(236547.235));
    }
}
