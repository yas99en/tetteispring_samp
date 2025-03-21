package com.example.demo.domain.service.password;

import org.springframework.stereotype.Component;

// ユーティリティクラスやサポートクラスなどに付与するアノテーション
@Component
public class Sha256PasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(String rawPassword) {
		// 実際のencode処理は省略
		return "Using Sha256PasswordEncoder!";
	}
}
