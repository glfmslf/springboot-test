package com.yy.zipkin2.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/24 16:57
 */
@RestController
public class ZipkinS {

    @RequestMapping("/zipkins")
    public String helloZipkin(){
        return "This is zipkin second";
    }
}
