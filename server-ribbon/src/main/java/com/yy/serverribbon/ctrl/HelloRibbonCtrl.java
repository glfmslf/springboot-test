package com.yy.serverribbon.ctrl;

import com.yy.serverribbon.service.HelloRibbon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/16 17:49
 */
@RestController
public class HelloRibbonCtrl {

    @Autowired
    private HelloRibbon helloRibbon;

    @RequestMapping(value = "/helloRibbon")
    public String helloRibbon(@RequestParam(value = "name") String name){
        return helloRibbon.helloRibbon(name);
    }
}
