package com.yy.mybatisredis.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author: youyu  工号：S37565
 * CREATED_DATE: 2018/7/12 12:02
 */
@Configuration
public class RedisConf {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * 创建redisTemplate,springboot会帮你创建，主要是可以自己自定义一些参数，
     * 同理RedisConnectionFactory也可以根据自己的需要重新定义
     * springboot很多时候都帮你创建好了，同时自己也定义了的话，优先使用自定义的，和配置文件的原理是一样的
     * @return
     */
    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * 创建基于String类型的redis操作对象，方便取用
     * @param redisTemplate
     * @return
     */
    @Bean
    public ValueOperations valueOperations(RedisTemplate redisTemplate){
        return redisTemplate.opsForValue();
    }

    /**
     * 创建基于set类型的redis操作对象
     * @param redisTemplate
     * @return
     */
    @Bean
    public SetOperations setOperations(RedisTemplate redisTemplate){
        return redisTemplate.opsForSet();
    }

    /**
     * 创建基于zset类型的redis操作对象
     * @param redisTemplate
     * @return
     */
    @Bean
    public ZSetOperations zSetOperations(RedisTemplate redisTemplate){
        return redisTemplate.opsForZSet();
    }

    /**
     * 创建基于list类型的redis操作对象
     * @param redisTemplate
     * @return
     */
    @Bean
    public ListOperations listOperations(RedisTemplate redisTemplate){
        return redisTemplate.opsForList();
    }

    /**
     * 创建基于hash类型的redis操作对象
     * @param redisTemplate
     * @return
     */
    @Bean
    public HashOperations hashOperations(RedisTemplate redisTemplate){
        return redisTemplate.opsForHash();
    }

    /**
     * 创建基于Geo类型的redis操作对象
     * @param redisTemplate
     * @return
     */
    @Bean
    public GeoOperations geoOperations(RedisTemplate redisTemplate){
        return redisTemplate.opsForGeo();
    }

    /**
     * 创建基于cluster类型的redis操作对象
     * @param redisTemplate
     * @return
     */
    @Bean
    public ClusterOperations clusterOperations(RedisTemplate redisTemplate){
        return redisTemplate.opsForCluster();
    }

    /**
     * 创建基于hyper类型的redis操作对象
     * @return
     */
    @Bean
    public HyperLogLogOperations hyperLogLogOperations(){
        return redisTemplate().opsForHyperLogLog();
    }
}
