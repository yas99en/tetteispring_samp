package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertieConfig {
    // 13.5.1. @ConfigurationPropertiesを用いたプロパティの設定 @ConfigurationPropertiesを@Beanメソッドに付与する際のBean定義例
    @Bean
    @ConfigurationProperties(prefix = "target")
    public TargetProperties1 targetProperties1() {
        return new TargetProperties1();
    }
}