package com.yy.hystrixribbon.conf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/18 10:30
 */
@Configuration
public class RibbonCon {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule randomRule(){
        return new RandomRule();
    }
}
