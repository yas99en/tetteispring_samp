package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

// 9.5.5 メソッドへの認可
@Configuration
@EnableMethodSecurity
public class MethodSecurityConfig {
}
