package com.yy.hystrixfeign;

import org.springframework.stereotype.Component;

/**
 * @author: youyu  工号：S37565
 * 需要将此类加入spring管理，否则开启了hystrix，并且interface中配置了fallback将会报错
 * 注意：网上都说feign集成了hystrix，不需要要导入springboot hystrix引导pom，
 * 实际上我的报classnotfound，我的是2.0.0 Finchley版的，可能是版本问题，springboot后来更新了
 * CREATED_DATE: 2018/7/18 11:40
 */
@Component
public class HystrixImpl implements HystrixInterface {
    @Override
    public String helloHystrix(String name) {
        return name + " error";
    }
}
