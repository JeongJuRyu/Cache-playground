package com.example.jediscache.config;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {
    public static class CacheProperty {
        private String name;
        private Integer ttl;
    }
}
