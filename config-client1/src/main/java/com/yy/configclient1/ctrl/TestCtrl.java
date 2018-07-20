package com.yy.configclient1.ctrl;

import com.yy.configclient1.conf.PropertiesConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/20 14:14
 */
@RestController
public class TestCtrl {

    @Autowired
    private PropertiesConf propertiesConf;
//    @Value("${name}")
//    private String name;
//    @Value("${demo.test}")
//    private String test;
    @RequestMapping("/helloConf")
    public String readPro(){

        return propertiesConf.getTest() + "YOUYU";
//        return test + "YOUYU";
//        return name;
    }
}
