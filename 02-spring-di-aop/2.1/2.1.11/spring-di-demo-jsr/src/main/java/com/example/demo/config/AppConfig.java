package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Jsr330ScopeMetadataResolver;

// 2.1.11. JSR 330: Dependency Injection for Java BeanのデフォルトのスコープをprototypeにするJava Configの実装例
@Configuration
@ComponentScan(basePackages = "com.example.demo", scopeResolver = Jsr330ScopeMetadataResolver.class)
public class AppConfig {
}
