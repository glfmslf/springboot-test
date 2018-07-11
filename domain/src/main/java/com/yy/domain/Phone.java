package com.yy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/11 11:23
 */
@Data
@AllArgsConstructor
@ToString
public class Phone {
    private String phoneName;
    private long prince;
    private String color;
}
