package com.example.demo.domain.repository;

import com.example.demo.domain.model.User;

// 2.1. SpringによるDI(依存性の注入) ユーザー情報を操作するインターフェイスの実装例
public interface UserRepository {
	// ユーザー情報を永続化層に保存する
	User save(User user);
	// ユーザー数をカウントする
	int countByUsername(String username);
}
