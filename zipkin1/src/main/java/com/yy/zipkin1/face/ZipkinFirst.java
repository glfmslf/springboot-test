package com.yy.zipkin1.face;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "zipkin2")
public interface ZipkinFirst {
    @RequestMapping("/zipkins")
    public String helloZipkin();
}
