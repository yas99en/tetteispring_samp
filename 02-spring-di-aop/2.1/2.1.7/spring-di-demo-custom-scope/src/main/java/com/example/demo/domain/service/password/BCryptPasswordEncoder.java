package com.example.demo.domain.service.password;

import java.time.LocalDateTime;

// AppConfigにBean定義している
public class BCryptPasswordEncoder implements PasswordEncoder {
	
	// コンストラクタの処理を実装する（本サンプルプログラムでは省略）
	public BCryptPasswordEncoder() {
		// @Scope("thread")が正常に動作し、スレッドスコープとなった結果、
		// スレッドごとにコンストラクタが実行されていることを確認するために
		// オブジェクト生成時刻を表示している
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": BCryptPasswordEncoder Object Generation Time: " + LocalDateTime.now());
	}
	
	@Override
	public String encode(String rawPassword) {
		// 実際のencode処理は省略
		return "Using BCryptPasswordEncoder!";
	}
	
}