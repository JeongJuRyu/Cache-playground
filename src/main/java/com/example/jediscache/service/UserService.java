package com.example.jediscache.service;

import com.example.jediscache.entity.User;
import com.example.jediscache.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final RedisTemplate<String, User> userRedisTemplate;
    public User getUser(final Long id) {
        // 1. cache get

        // 2. else
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
