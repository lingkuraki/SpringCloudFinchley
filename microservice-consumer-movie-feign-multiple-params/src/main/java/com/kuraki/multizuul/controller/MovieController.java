package com.kuraki.multizuul.controller;

import com.kuraki.multizuul.entity.User;
import com.kuraki.multizuul.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }

    /**
     * 该请求不会成功
     */
    @GetMapping("/user/get0")
    public User get0(User user) {
        return userFeignClient.get0(user);
    }

    @GetMapping("/user/get1")
    public User get1(User user) {
        return userFeignClient.get1(user.getId(), user.getUsername());
    }

    @GetMapping("/user/get2")
    public User get2(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("username", user.getUsername());
        return userFeignClient.get2(map);
    }

    @GetMapping("/user/post")
    public User post(User user) {
        return this.userFeignClient.post(user);
    }

}
