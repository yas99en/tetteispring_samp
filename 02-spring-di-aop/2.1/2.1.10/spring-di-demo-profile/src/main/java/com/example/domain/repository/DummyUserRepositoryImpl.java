package com.example.domain.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.domain.model.User;

// 2.1.10.1. プロファイルの定義方法 プロファイル名を指定したアノテーションによるBean定義の実装例
// 「productionプロファイル以外」というように否定形でプロファイルを指定することができる
@Component
@Profile("!production")
public class DummyUserRepositoryImpl implements UserRepository {

	@Override
	public User save(User user) {
		// 実際のsave処理は省略
		System.out.println("DummyUserRepositoryImpl save 実行: User Saved! (username: " + user.getUsername() + ", password: " + user.getPassword() + ")");
		return user;
	}

	@Override
	public int countByUsername(String username) {
		// 実際のcount処理は省略
		return 0;
	}

}
