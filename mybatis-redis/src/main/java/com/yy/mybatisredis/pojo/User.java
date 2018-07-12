package com.yy.mybatisredis.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/12 11:42
 */
@Data
public class User implements Serializable {
    private String id;
    private String userName;
    private String phoneNo;
    private String password;
}
