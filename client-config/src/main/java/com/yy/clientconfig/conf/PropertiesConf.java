package com.yy.clientconfig.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/20 14:11
 */
@Component
@ConfigurationProperties(prefix = "demo")
public class PropertiesConf {

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
