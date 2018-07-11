package com.yy.dubboconsumer;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.yy.dubboconsumer.consumer.PhoneConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.yy.dubboconsumer.consumer")
@ComponentScan(basePackages = "com.yy.dubboconsumer")
public class DubboConsumerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DubboConsumerApplication.class, args);
        PhoneConsumer phoneConsumer = context.getBean(PhoneConsumer.class);
        phoneConsumer.printPhone();
    }
}
