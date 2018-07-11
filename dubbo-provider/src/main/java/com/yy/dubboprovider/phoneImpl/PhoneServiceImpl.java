package com.yy.dubboprovider.phoneImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yy.domain.Phone;
import com.yy.face.PhoneFace;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/11 11:29
 */
@Service
public class PhoneServiceImpl implements PhoneFace {
    @Override
    public Phone getPhone(String phoneName, long prince, String color) {
        return new Phone(phoneName,prince,color);
    }
}
