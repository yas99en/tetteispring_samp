package com.example.demo.domain.service;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.service.exception.UserAlreadyRegisteredException;
import com.example.demo.domain.service.password.PasswordEncoder;

public class ConstructorInjectionUserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public ConstructorInjectionUserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public void register(User user, String rawPassword) {
		System.out.println("ConstructorInjectionUserServiceImpl register 実行: User registration");
		if (this.userRepository.countByUsername(user.getUsername()) > 0) {
			// ユーザー名がすでに使用されていたら例外をスローする
			throw new UserAlreadyRegisteredException();
		}
		// 生パスワードをハッシュ化して設定
		user.setPassword(this.passwordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}

}
