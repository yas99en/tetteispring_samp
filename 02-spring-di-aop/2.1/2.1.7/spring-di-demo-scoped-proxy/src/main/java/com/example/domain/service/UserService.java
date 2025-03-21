package com.example.domain.service;

import com.example.domain.model.User;

public interface UserService {
	// ユーザー情報を登録する処理	
	void register(User user, String rawPassword);
}
