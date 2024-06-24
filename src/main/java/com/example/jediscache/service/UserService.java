package com.example.jediscache.service;

import com.example.jediscache.entity.RedisHashUser;
import com.example.jediscache.entity.User;
import com.example.jediscache.repository.RedisHashUserRepository;
import com.example.jediscache.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

import static com.example.jediscache.config.CacheConfig.CACHE1;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final RedisHashUserRepository redisHashUserRepository;
    private final RedisTemplate<String, User> userRedisTemplate;
    private final RedisTemplate<String, Object> objectRedisTemplate;
    public User getUser(final Long id) {
        // 1. cache get
        String key = "users:%d".formatted(id);
        var cachedUser = objectRedisTemplate.opsForValue().get(key);
        if(cachedUser != null){
            return (User)cachedUser;
        }
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        objectRedisTemplate.opsForValue().set(key, user, Duration.ofSeconds(30));

        return user;
    }

    public RedisHashUser getUser2(final Long id) {
        var cachedUser =  redisHashUserRepository.findById(id).orElseGet(() -> {
            User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
            return redisHashUserRepository.save(RedisHashUser.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .createdAt(user.getCreatedAt())
                    .updatedAt(user.getUpdatedAt())
                    .build());
        });
        return cachedUser;
    }

    @Cacheable(cacheNames = CACHE1, key = "'user:' + #id")
//    @Cacheable(value = "getUser3", key = "'user:' + #id")
    public User getUser3(final Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
