package com.example.jediscache.repository;

import com.example.jediscache.entity.RedisHashUser;
import org.springframework.data.repository.CrudRepository;

public interface RedisHashUserRepository extends CrudRepository<RedisHashUser, Long> {
}
