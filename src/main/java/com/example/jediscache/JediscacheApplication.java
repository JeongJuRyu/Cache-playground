package com.example.jediscache;

import com.example.jediscache.entity.User;
import com.example.jediscache.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class JediscacheApplication implements ApplicationRunner {
    private final UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(JediscacheApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(User.builder()
                .name("greg")
                .email("greg@fastcampus.co.kr")
                .build());
        userRepository.save(User.builder()
                .name("greg2")
                .email("greg2@fastcampus.co.kr")
                .build());
        userRepository.save(User.builder()
                .name("greg3")
                .email("greg3@fastcampus.co.kr")
                .build());
        userRepository.save(User.builder()
                .name("greg4")
                .email("greg4@fastcampus.co.kr")
                .build());
    }
}
