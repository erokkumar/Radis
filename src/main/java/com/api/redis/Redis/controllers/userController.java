package com.api.redis.Redis.controllers;

import com.api.redis.Redis.Dao.UserDao;
import com.api.redis.Redis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    private UserDao userDao;

    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setUserId(UUID.randomUUID().toString());
        User data = userDao.save(user);
        return data;
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId){
        return userDao.findById(userId);
    }

    @GetMapping
    public List<User> getAllUsers(){
        Map<Object, Object> all = userDao.findall();
        Collection<Object> values = all.values();
        List<User> collect = values.stream().map(obj -> (User) obj).collect(Collectors.toList());
        return collect;
    }

    @DeleteMapping("/del/{userId}")
    public User deleteUser(@PathVariable ("userId") String userId){
        return userDao.delete(userId);
    }


}
