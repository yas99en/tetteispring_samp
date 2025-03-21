package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.repository.UserRepositoryImpl;
import com.example.demo.domain.service.UserService;
import com.example.demo.domain.service.UserServiceImpl;
import com.example.demo.domain.service.password.BCryptPasswordEncoder;
import com.example.demo.domain.service.password.PasswordEncoder;

// 2.1.9.1. Java Configの分割 分割したコンフィギュレーションクラスの実装例(DomainConfig.java)
@Configuration
public class DomainConfig {
	
	@Bean
	UserService userService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return new UserServiceImpl(userRepository, passwordEncoder);
	}
		
	@Bean
	PasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserRepository userRepository() {
		return new UserRepositoryImpl();
	}
	
}
