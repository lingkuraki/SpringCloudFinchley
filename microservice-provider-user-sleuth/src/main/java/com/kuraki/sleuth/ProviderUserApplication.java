package com.kuraki.sleuth;

import com.kuraki.sleuth.entity.User;
import com.kuraki.sleuth.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.stream.Stream;

@SpringBootApplication
public class ProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderUserApplication.class, args);
    }

    @Bean
    public ApplicationRunner init(UserRepository userRepository) {
        return args -> {
            User user1 = new User(1L, "kuraki", "张三", 20, new BigDecimal(100.00));
            User user2 = new User(2L, "lingbo", "李四", 28, new BigDecimal(180.00));
            User user3 = new User(3L, "爷傲丶奈我何", "疾风剑豪", 35, new BigDecimal(280.00));

            Stream.of(user1, user2, user3).forEach(userRepository::save);
        };
    }
}
