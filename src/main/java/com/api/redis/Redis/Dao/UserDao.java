package com.api.redis.Redis.Dao;

import com.api.redis.Redis.models.User;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "USER";

    public User save(User user) {
        redisTemplate.opsForHash().put(KEY, user.getUserId(), user);
        return user;
    }

    public User findById(String userId){
        return (User) redisTemplate.opsForHash().get(KEY, userId);
    }

    public Map<Object, Object> findall(){
        return redisTemplate.opsForHash().entries(KEY);
    }

    public User delete(String userId){
        User user = findById(userId);
        redisTemplate.opsForHash().delete(KEY, userId);
        return user;
    }
}
