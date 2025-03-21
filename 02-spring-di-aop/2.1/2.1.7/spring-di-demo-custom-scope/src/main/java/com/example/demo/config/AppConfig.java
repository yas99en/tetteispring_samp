package com.example.demo.config;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.SimpleThreadScope;

import com.example.demo.domain.service.password.PasswordEncoder;
import com.example.demo.domain.service.password.BCryptPasswordEncoder;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class AppConfig {
	
	@Bean
	@Scope("thread")
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// 2.1.7.3. カスタムスコープ 独自のスコープの実装例
	@Bean
	static CustomScopeConfigurer customScopeConfigurer() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		configurer.addScope("thread", new SimpleThreadScope());
		return configurer;
	}
	
}
