package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.repository.UserRepositoryImpl;
import com.example.demo.domain.service.NullableUserServiceImpl;
import com.example.demo.domain.service.UserService;
import com.example.demo.domain.service.password.BCryptPasswordEncoder;
import com.example.demo.domain.service.password.PasswordEncoder;

@Configuration
public class AppConfig {
	
	@Bean
    UserRepository userRepository() {
        return new UserRepositoryImpl();
    }
	
	@Bean
    UserService nullableUserService() {
        return new NullableUserServiceImpl();
    }
	
	// Bean定義をしない
//	@Bean
	PasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
}
