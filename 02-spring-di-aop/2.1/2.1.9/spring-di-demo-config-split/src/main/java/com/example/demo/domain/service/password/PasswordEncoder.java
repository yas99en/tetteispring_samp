package com.example.demo.domain.service.password;

public interface PasswordEncoder {
	// パスワードをハッシュ化する処理
	String encode(String rawPassword);
}
