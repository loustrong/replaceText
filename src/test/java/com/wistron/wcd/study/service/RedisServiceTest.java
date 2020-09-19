package com.wistron.wcd.study.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml",
        "classpath:spring-redis.xml"})

public class RedisServiceTest {
    @Autowired
    RedisService redisService;
    @Test
    public void set() {
        boolean isOk = redisService.set("Tom","Lou");
        System.out.println(isOk);
    }


    @Test
    public void get() {

        String getKey = (String)redisService.get("Tom");
        System.out.println("getKey:" + getKey);
    }

}