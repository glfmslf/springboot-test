package com.yy.hystrixribbon.conf.ctrl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/18 10:32
 */
@RestController
public class HelloHystrix {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HystrixService hystrixService;
    @RequestMapping("/helloHystrix")
    @HystrixCommand(fallbackMethod = "hystrixError")
    public String helloHystrix(@RequestParam("name") String name){
        return restTemplate.getForObject("http://eureka-client/helloEureka?name=" + name,String.class);
    }

    public String hystrixError(String name){
        return name + "is error";
    }
}
