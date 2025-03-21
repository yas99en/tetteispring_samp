package com.example.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.model.User;
import com.example.domain.repository.UserRepository;
import com.example.domain.service.exception.UserAlreadyRegisteredException;
import com.example.domain.service.password.PasswordEncoder;

// 2.1.7.2.2. Scoped Proxy UserServiceImplにおけるPasswordEncoderのインジェクションの実装例
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void register(User user, String rawPassword) {
		if (this.userRepository.countByUsername(user.getUsername()) > 0) {
			// ユーザー名がすでに使用されていたら例外をスローする
			throw new UserAlreadyRegisteredException();
		}
		// 生パスワードをハッシュ化して設定
		user.setPassword(this.passwordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}

}
