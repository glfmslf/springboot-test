package com.yy.feign;

import com.yy.feign.inteface.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/17 10:52
 */
@RestController
public class ctrl {

    @Autowired
    private HelloFeign helloFeign;

    @RequestMapping(value = "/helloFeign")
    public String helloFeign(String name){
        return helloFeign.helloFeign(name);
    }
}
