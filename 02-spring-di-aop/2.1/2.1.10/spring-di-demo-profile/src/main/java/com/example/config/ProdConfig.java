package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.domain.model.Properties;

// 2.1.10.1. プロファイルの定義方法 プロファイル名を指定したJava Configの実装例
@Configuration
@Profile("production")
public class ProdConfig {
	@Bean
	Properties properties() {
		return new Properties("info");
	}
}
