package com.kuraki.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

@Service
@Slf4j
public class RedisService {

    @Autowired
    private RedisLockRegistry redisLockRegistry;

    public void test() throws InterruptedException {

        Lock lock = redisLockRegistry.obtain("lock");
        boolean b1 = lock.tryLock(3, TimeUnit.SECONDS);
        log.info("b1 is : {}", b1);

        TimeUnit.SECONDS.sleep(5);

        boolean b2 = lock.tryLock(3, TimeUnit.SECONDS);
        log.info("b2 is : {}",b2);

        lock.unlock();
    }
}
