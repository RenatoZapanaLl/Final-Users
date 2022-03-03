package com.example.MSUsers.Repository;

import com.example.MSUsers.Domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;

@Repository
public class UsersRepository  implements RedisRepository{
    private  static final String KEY = "Users";

    @Autowired
    private RedisTemplate<String,Users> redisTemplate;
    private HashOperations hashOperations;

    public UsersRepository(RedisTemplate<String,Users> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private  void  init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Users> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public Users findById(String id) {
        return (Users) hashOperations.get(KEY,id);
    }

    @Override
    public void save(Users clients) {
        hashOperations.put(KEY, UUID.randomUUID().toString(),clients);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY,id);
    }
}
