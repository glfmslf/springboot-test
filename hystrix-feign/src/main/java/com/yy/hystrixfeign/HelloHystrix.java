package com.yy.hystrixfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/18 11:38
 */
@RestController
public class HelloHystrix {

    @Autowired
    private HystrixInterface hystrixInterface;
    @RequestMapping("/helloHystrix")
    public String helloHystrix(@RequestParam("name") String name){
        return hystrixInterface.helloHystrix(name);
    }
}
