package com.example.demo.domain.service.password;

// 2.1. SpringによるDI(依存性の注入) パスワードをハッシュ化するインターフェイスの実装例
public interface PasswordEncoder {
	// パスワードをハッシュ化する処理
	String encode(String rawPassword);
}
