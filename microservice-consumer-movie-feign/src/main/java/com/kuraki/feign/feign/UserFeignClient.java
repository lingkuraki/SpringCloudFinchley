package com.kuraki.feign.feign;

import com.kuraki.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
