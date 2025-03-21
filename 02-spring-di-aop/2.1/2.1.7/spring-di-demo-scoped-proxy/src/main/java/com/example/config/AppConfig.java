package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.example.domain.repository.UserRepository;
import com.example.domain.repository.UserRepositoryImpl;
import com.example.domain.service.UserService;
import com.example.domain.service.UserServiceImpl;
import com.example.domain.service.password.PasswordEncoder;
import com.example.domain.service.password.ThreadUnsafePasswordEncoder;

@Configuration
public class AppConfig {
	
	@Bean
    UserRepository userRepository() {
        return new UserRepositoryImpl();
    }
	
    @Bean
    UserService userService() {
        return new UserServiceImpl();
    }
    
	// 2.1.7.2.2. Scoped Proxy Scoped Proxyを有効にするJava Configの実装例
	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	PasswordEncoder passwordEncoder() {
		return new ThreadUnsafePasswordEncoder();
	}
	
}