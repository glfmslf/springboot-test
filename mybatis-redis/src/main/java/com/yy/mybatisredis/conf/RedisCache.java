package com.yy.mybatisredis.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/12 14:39
 */
@Component
public class RedisCache {

    @Autowired
    public void setRedisconnectionFactroy(RedisConnectionFactory redisconnectionFactroy){
        MybatisRedisCache.setRedisConnectionFactory(redisconnectionFactroy);
    }
}
