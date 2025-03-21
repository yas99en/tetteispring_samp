package com.example.domain.service.password;

import java.time.LocalDateTime;

public class ThreadUnsafePasswordEncoder implements PasswordEncoder {
	
	// コンストラクタの処理を実装する（本サンプルプログラムでは省略）
	public ThreadUnsafePasswordEncoder() {
		// @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)が正常に動作し、requestスコープとなった結果、
		// リクエスト処理を実行する度にコンストラクタが実行されていることを確認するために
		// オブジェクト生成時刻を表示している
		System.out.println("ThreadUnsafePasswordEncoder Object Generation Time: " + LocalDateTime.now());
	}
	
	@Override
	public String encode(String rawPassword) {
		// 実際のencode処理は省略
		return "Using ThreadUnsafePasswordEncoder!";
	}
	
}
