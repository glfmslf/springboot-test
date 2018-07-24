package com.yy.zipkin1.ctrl;

import com.netflix.discovery.converters.Auto;
import com.yy.zipkin1.face.ZipkinFirst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/24 17:00
 */
@RestController
public class ZipkinF {
    @Autowired
    private ZipkinFirst zipkinFirst;
    @RequestMapping("/helloZipkinf")
    public String helloZipkin(){
        return zipkinFirst.helloZipkin();
    }
}
