package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.service.UserService;
import com.example.demo.domain.service.UserServiceImpl;
import com.example.demo.domain.service.password.PasswordEncoder;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class AppConfig {
	// 2.1.8.1.3. Post Construct Java Configの場合
	// 2.1.8.2.1. Pre Destroy Java Configの場合
	@Bean(initMethod = "populateCacheInitMethod", destroyMethod = "clearCacheDestroyMethod")
	UserService userService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
	    return new UserServiceImpl(userRepository, passwordEncoder);
	}
}
