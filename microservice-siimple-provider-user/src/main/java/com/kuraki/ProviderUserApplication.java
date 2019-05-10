package com.kuraki;

import com.kuraki.dao.UserRepository;
import com.kuraki.entity.User;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderUserApplication.class, args);
    }

    /**
     * 初始化用户信息
     */
    @Bean
    ApplicationRunner init(UserRepository repository) {
        return args -> {
            User user1 = new User(1L, "account1", "张三", 20, new BigDecimal(100.0));
            User user2 = new User(2L, "account2", "李四", 30, new BigDecimal(200.0));
            User user3 = new User(3L, "account3", "王五", 40, new BigDecimal(300.0));
            Stream.of(user1, user2, user3).forEach(repository::save);
        };
    }
}
