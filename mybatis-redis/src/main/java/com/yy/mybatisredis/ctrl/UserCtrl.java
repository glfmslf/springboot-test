package com.yy.mybatisredis.ctrl;

import com.yy.mybatisredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/12 11:41
 */
@RestController
public class UserCtrl {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser/{id}")
    public String getUser(@PathVariable("id") Integer id){
        return userService.getUserById(id).toString();
    }
}
