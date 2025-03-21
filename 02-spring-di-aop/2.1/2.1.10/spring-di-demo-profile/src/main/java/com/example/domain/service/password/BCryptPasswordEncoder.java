package com.example.domain.service.password;

import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(String rawPassword) {
		// 実際のencode処理は省略
		return "Using BCryptPasswordEncoder!";
	}
}
