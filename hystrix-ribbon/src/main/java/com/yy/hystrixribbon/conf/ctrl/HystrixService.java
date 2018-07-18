package com.yy.hystrixribbon.conf.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/18 10:45
 */
@Service
public class HystrixService {

    @Autowired
    private RestTemplate restTemplate;

    public String helloHystrix(String name){
        return restTemplate.getForObject("http://eureka-client/helloEureka?name=" + name,String.class);
    }
}
