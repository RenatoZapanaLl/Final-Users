package com.example.MSUsers.Repository;

import com.example.MSUsers.Domain.Users;

import java.util.Map;

public interface RedisRepository {
    Map<String, Users> findAll();
    Users findById(String id);
    void save(Users users);
    void delete(String id);
}
