package com.yy.mybatisredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yy.mybatisredis.mapper")
public class MybatisRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisRedisApplication.class, args);
    }
}
