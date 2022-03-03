package com.example.MSUsers.Domain;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
@Data
@RedisHash("Users")
public class Users implements Serializable {
    private  String NamesClients;
    private  String DNI;
    private  String NumberPhone;
    private  String email;
}
