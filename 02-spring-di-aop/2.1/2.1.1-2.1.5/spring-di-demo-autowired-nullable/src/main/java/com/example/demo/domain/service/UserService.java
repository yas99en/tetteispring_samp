package com.example.demo.domain.service;

import com.example.demo.domain.model.User;

// 2.1. SpringによるDI(依存性の注入) ユーザー登録処理を行なうインターフェイスの実装例
public interface UserService {
	// ユーザー情報を登録する処理
	void register(User user, String rawPassword);
}
