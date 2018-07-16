package com.yy.serverribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/16 17:41
 */
@Service
public class HelloRibbon {

    @Autowired
    private RestTemplate restTemplate;

    public String helloRibbon(String name){
        //其中，eureka-client为服务名，可将其设置为多例模式，不同端口启动，查看端口号是否一致
        return restTemplate.getForObject("http://eureka-client/helloEureka?name=" + name,String.class);
    }
}
