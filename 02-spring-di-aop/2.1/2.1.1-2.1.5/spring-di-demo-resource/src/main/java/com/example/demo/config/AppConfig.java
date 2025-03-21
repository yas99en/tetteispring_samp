package com.example.demo.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.repository.UserRepositoryImpl;
import com.example.demo.domain.service.UserService;
import com.example.demo.domain.service.UserServiceImpl;
import com.example.demo.domain.service.collection.IF;
import com.example.demo.domain.service.collection.IntIF1;
import com.example.demo.domain.service.collection.IntIF2;
import com.example.demo.domain.service.collection.StringIF;
import com.example.demo.domain.service.password.BCryptPasswordEncoder;
import com.example.demo.domain.service.password.PasswordEncoder;
import com.example.demo.domain.service.password.Sha256PasswordEncoder;

@Configuration
public class AppConfig {
	
	@Bean
	UserRepository userRepository() {
		return new UserRepositoryImpl();
	}
	
	@Bean
    UserService userServiceImpl() {
        return new UserServiceImpl();
    }
	
	@Bean
    PasswordEncoder sha256PasswordEncoder() {
        return new Sha256PasswordEncoder();
    }
	
	@Bean
	PasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// 2.1.5.3. コレクションやマップ型のオートワイヤリング リストやマップのBean定義の実装例
	@Bean
	List<IF<?>> ifList() {
		return Arrays.asList(new IntIF1(), new IntIF2(), new StringIF()); 
	}
	
	// 2.1.5.3. コレクションやマップ型のオートワイヤリング リストやマップのBean定義の実装例
	@Bean
	Map<String, IF<?>> ifMap() {
		Map<String, IF<?>> map = new HashMap<>(); 
		map.put("intIF1", new IntIF1()); 
		map.put("intIF2", new IntIF2()); 
		map.put("stringIF", new StringIF()); 
		return map;
	}

}
