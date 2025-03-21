package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.domain.service.password.PasswordEncoder;
import com.example.demo.domain.service.password.ThreadUnsafePasswordEncoder;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class AppConfig {
	// 2.1.7.2. 異なるスコープのインジェクション prototypeスコープのPasswordEncoderのBean定義
	@Bean
	@Scope("prototype")
	PasswordEncoder passwordEncoder() {
		// スレッドアンセーフなので、singletonで使ってはいけない
		return new ThreadUnsafePasswordEncoder();
	}
}
