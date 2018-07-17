package com.yy.serverribbon.conf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
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

    /**
     * 配置负载均衡策略,实例化不同策略实例，相关策略请翻阅文档
     * 此种方式使用springboot创建的ribbon实例
     * 如果需要自己创建ribbon实例，另配置一个configuration类，如此包下的configurationRibbon类，
     * 配置ribbonClient注解，包含具体的ribbon配置类
     * 即可实现自定义ribbon实例，相关文档参考官网
     * @return
     */
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
