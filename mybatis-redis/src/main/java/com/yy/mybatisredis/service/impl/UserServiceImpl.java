package com.yy.mybatisredis.service.impl;

import com.yy.mybatisredis.mapper.UserMapper;
import com.yy.mybatisredis.pojo.User;
import com.yy.mybatisredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/12 14:55
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(Integer id) {
        User user = userMapper.getUserById(id);
        return user;
    }
}
