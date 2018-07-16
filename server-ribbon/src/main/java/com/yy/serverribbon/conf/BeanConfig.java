package com.yy.serverribbon.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/16 17:34
 */
@Configuration
public class BeanConfig {
    /**
     * 要达到负载均衡的效果，需要创建RestTemplate对象，并且需要加入@loadBalanced注解
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
