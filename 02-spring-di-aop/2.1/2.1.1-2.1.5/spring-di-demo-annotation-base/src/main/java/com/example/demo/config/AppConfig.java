package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 2.1.3.3. アノテーションベースConfiguration コンポーネントスキャンを有効にするJava Configの実装例
@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class AppConfig {	
}
