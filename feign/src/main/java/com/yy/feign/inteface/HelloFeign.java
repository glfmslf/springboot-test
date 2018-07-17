package com.yy.feign.inteface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client")
public interface HelloFeign {

    @RequestMapping(value = "/helloEureka")
    String helloFeign(@RequestParam(value = "name") String name);
}
