package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 2.2.2. Spring AOP Spring AOPを有効にするJava Configの定義例
@Configuration
@ComponentScan({"com.example.aspect", "com.example.domain"})
@EnableAspectJAutoProxy
public class AppConfig {
}
