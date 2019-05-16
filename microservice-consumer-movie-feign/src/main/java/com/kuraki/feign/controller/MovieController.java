package com.kuraki.feign.controller;

import com.kuraki.feign.entity.User;
import com.kuraki.feign.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/movies")
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient feignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.feignClient.findById(id);
    }
}
