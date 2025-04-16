package com.DatNguyen.AuthService.Service.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class BlackTokenService {
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public BlackTokenService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void blacklistToken(String email, String token, long expirationSeconds) {
        String blacklistKey = "BLACKLIST:" + email;
        redisTemplate.opsForSet().add(blacklistKey, token);
        redisTemplate.expire(blacklistKey, Duration.ofSeconds(expirationSeconds));
    }



    public boolean isTokenBlacklisted(String token) {
        return redisTemplate.hasKey(token);
    }
}
