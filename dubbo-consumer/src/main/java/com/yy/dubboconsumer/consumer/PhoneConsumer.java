package com.yy.dubboconsumer.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yy.domain.Phone;
import com.yy.face.PhoneFace;
import org.springframework.stereotype.Component;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/11 15:28
 */
@Component
public class PhoneConsumer {
    @Reference
    PhoneFace phoneFace;
    public void printPhone(){
        Phone phone = phoneFace.getPhone("iphone",5899,"red");
        System.out.println(phone.toString());
    }
}
