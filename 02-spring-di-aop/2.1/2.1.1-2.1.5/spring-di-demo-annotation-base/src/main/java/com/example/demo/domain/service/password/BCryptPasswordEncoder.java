package com.example.demo.domain.service.password;

import org.springframework.stereotype.Component;

// 2.1.3.3. アノテーションベースConfiguration Bean定義を行なうアノテーションによるBean定義の実装例(BCryptPasswordEncoder.java)
@Component
public class BCryptPasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(String rawPassword) {
		// 実際のencode処理は省略
		return "Using BCryptPasswordEncoder!";
	}
}
