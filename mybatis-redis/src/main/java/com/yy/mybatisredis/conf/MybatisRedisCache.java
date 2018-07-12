package com.yy.mybatisredis.conf;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: youyu  工号：S37565
 * mybatis 缓存类，实现cache
 * CREATED_DATE: 2018/7/12 14:04
 */
public class MybatisRedisCache implements Cache {

    private static RedisConnectionFactory redisConnectionFactory;
    private final String id;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public MybatisRedisCache(String id) throws IllegalAccessException {
        if (id == null){
            throw new IllegalAccessException("Cache instance require an ID");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object o, Object o1) {
        RedisConnection redisConnection = redisConnectionFactory.getConnection();
        RedisSerializer redisSerializer = new JdkSerializationRedisSerializer();
        redisConnection.set(redisSerializer.serialize(o),redisSerializer.serialize(o1));
    }

    @Override
    public Object getObject(Object o) {
        Object result = null;
        RedisConnection redisConnection = redisConnectionFactory.getConnection();
        RedisSerializer redisSerializer = new JdkSerializationRedisSerializer();
        result = redisSerializer.deserialize(redisConnection.get(redisSerializer.serialize(o)));
        return result;

    }

    @Override
    public Object removeObject(Object o) {
        Object result = null;
        RedisConnection redisConnection = redisConnectionFactory.getConnection();
        RedisSerializer redisSerializer = new JdkSerializationRedisSerializer();
        result = redisConnection.expire(redisSerializer.serialize(o),0);
        return result;
    }

    @Override
    public void clear() {
        RedisConnection redisConnection = redisConnectionFactory.getConnection();
        redisConnection.flushDb();
        redisConnection.flushAll();
    }

    @Override
    public int getSize() {
        int result = 0;
        RedisConnection redisConnection = redisConnectionFactory.getConnection();
        result = Integer.valueOf(redisConnection.dbSize().toString());
        return result;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

    public static void setRedisConnectionFactory(RedisConnectionFactory redisConnectionFactory) {
        MybatisRedisCache.redisConnectionFactory = redisConnectionFactory;
    }
}
