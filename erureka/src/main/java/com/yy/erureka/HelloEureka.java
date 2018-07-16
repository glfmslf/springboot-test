package com.yy.erureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/16 16:18
 */
@RestController
public class HelloEureka {

    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping("helloEureka/{name}")
    public String helloEureka(@PathVariable String name){
        return name + " : " + applicationName;
    }
}
