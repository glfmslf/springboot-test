package com.yy.erureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 作为服务提供者
 */
@SpringBootApplication
@EnableEurekaClient
public class ErurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErurekaApplication.class, args);
    }
}
