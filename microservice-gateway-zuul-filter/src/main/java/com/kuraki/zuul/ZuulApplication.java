package com.kuraki.zuul;

import com.kuraki.zuul.filter.PreRequestLogFilter;
import com.kuraki.zuul.filter.RateLimitZuulFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

    @Bean
    public PreRequestLogFilter preRequestLogFilter(){
        return new PreRequestLogFilter();
    }

    @Bean
    public RateLimitZuulFilter rateLimitZuulFilter(){
        return new RateLimitZuulFilter();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApplication.class).run(args);
    }
}
