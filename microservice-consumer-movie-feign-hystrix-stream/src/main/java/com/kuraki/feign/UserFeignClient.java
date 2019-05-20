package com.kuraki.feign;

import com.kuraki.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "microservice-provider-user", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}

@Component
class UserFeignClientFallback implements UserFeignClient {

    @Override
    public User findById(Long id) {
        return new User(id, "地表最强", "永远最强", 0, new BigDecimal(1));
    }
}
