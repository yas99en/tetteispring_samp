package com.example.demo.domain.service.password;

public class BCryptPasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(String rawPassword) {
		// 実際のencode処理は省略
		return "Using BCryptPasswordEncoder!";
	}
}
