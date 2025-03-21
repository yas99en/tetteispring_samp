package com.example.demo.domain.service.password;

import org.springframework.stereotype.Component;

import com.example.demo.config.Exclude;

// 2.1.6.2. フィルタを明示したコンポーネントスキャン スキャン対象から除外するコンポーネントを指定するための設定例(Java Configの場合)
// このクラスはスキャン対象から除外される
@Exclude
// ユーティリティクラスやサポートクラスなどに付与するアノテーション
@Component
public class BCryptPasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(String rawPassword) {
		// 実際のencode処理は省略
		return "Using BCryptPasswordEncoder!";
	}
}
