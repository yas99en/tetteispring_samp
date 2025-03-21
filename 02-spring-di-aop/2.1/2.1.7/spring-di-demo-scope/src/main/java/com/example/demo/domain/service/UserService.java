package com.example.demo.domain.service;

import com.example.demo.domain.model.User;

public interface UserService {
	// ユーザー情報を登録する処理
	void register(User user, String rawPassword);
}
