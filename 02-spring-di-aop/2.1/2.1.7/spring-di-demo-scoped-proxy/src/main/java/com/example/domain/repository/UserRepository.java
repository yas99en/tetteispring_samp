package com.example.domain.repository;

import com.example.domain.model.User;

public interface UserRepository {
	// ユーザー情報を永続化層に保存する
	User save(User user);
	// ユーザー数をカウントする
	int countByUsername(String username);
}
