package com.example.demo.domain.repository;

import org.springframework.stereotype.Component;

import com.example.demo.domain.model.User;

// 2.1.3.3. アノテーションベースConfiguration Bean定義を行なうアノテーションによるBean定義の実装例(UserRepositoryImpl.java)
@Component
public class UserRepositoryImpl implements UserRepository {

	@Override
	public User save(User user) {
		// 実際のsave処理は省略
		System.out.println("UserRepositoryImpl save 実行: User Saved! (username: " + user.getUsername() + ", password: " + user.getPassword() + ")");
		return user;
	}

	@Override
	public int countByUsername(String username) {
		// 実際のcount処理は省略
		return 0;
	}

}
