package com.yy.hystrixfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/18 11:39
 */
@FeignClient(value = "eureka-client",fallback = HystrixImpl.class )
public interface HystrixInterface {

    @RequestMapping("/helloEureka")
    String helloHystrix(@RequestParam("name") String name);
}
