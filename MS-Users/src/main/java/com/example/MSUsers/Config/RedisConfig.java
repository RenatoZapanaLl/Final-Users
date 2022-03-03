package com.example.MSUsers.Config;

import com.example.MSUsers.Domain.Users;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory()
    {
        return  new JedisConnectionFactory();
    }
    @Bean
    RedisTemplate<String, Users> redisTemplate() {
        final RedisTemplate<String, Users> redisTemplate=new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return  redisTemplate;
    }
}
