package com.example.demo.domain.service.password;

import java.time.LocalDateTime;

import javax.inject.Named;

@Named
public class BCryptPasswordEncoder implements PasswordEncoder {
	
	// コンストラクタの処理を実装する（本サンプルプログラムでは省略）
	public BCryptPasswordEncoder() {
		// scopeResolver = Jsr330ScopeMetadataResolver.classが正常に動作し、prototypeスコープとなった結果、
		// Beanの取得時に毎回コンストラクタが実行されていることを確認するために
		// オブジェクト生成時刻を表示している
		System.out.println("BCryptPasswordEncoder Object Generation Time: " + LocalDateTime.now());
	}
		
	@Override
	public String encode(String rawPassword) {
		// 実際のencode処理は省略
		return "Using BCryptPasswordEncoder!";
	}
}
