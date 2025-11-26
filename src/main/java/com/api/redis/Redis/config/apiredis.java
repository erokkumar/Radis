package com.api.redis.Redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericJacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class apiredis {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {

        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String,Object> getRedisTemplate() {
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        //Connection Factory
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        //Key Serializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //Value Serializer
        //redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        return redisTemplate;
    }

}
