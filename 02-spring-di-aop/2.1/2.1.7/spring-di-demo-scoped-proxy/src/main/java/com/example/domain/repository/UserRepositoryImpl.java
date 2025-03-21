package com.example.domain.repository;

import com.example.domain.model.User;

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
