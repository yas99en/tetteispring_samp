package com.example.domain.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 2.4.2. Beanにプロパティをインジェクション アノテーションにおけるBean定義でプロパティファイルの値をバインディングする実装例
@Component
public class Authenticator {

	@Value("${failureCountToLock:5}")
	int failureCountToLock;
	
	private String username = "correct-username";
	
	private String password= "correct-password";
	
	private boolean locked;
	
	private int failureCount;
	
	/**
	* 認証処理
	*/
	public boolean authenticate(String username, String password) {
		if (locked) { // ロック状態
			System.out.print("ロックされています: ");
			return false;
		} else { // 非ロック状態
			if (this.username.equals(username) && this.password.equals(password)) { // 認証成功
				failureCount = 0;
				return true;
			} else { // 認証失敗
				// 連続認証失敗回数
				failureCount++;
				// 連続認証失敗回数が閾値を超えた場合にロックする
				if (failureCount >= failureCountToLock) {
					// ロック時の処理を実装（本サンプルプログラムでは省略）
					locked = true;
					System.out.print("ロックされました: ");
				}
				return false;
			}
		}
	}
	
}