package com.example.demo.domain.service;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.service.exception.UserAlreadyRegisteredException;
import com.example.demo.domain.service.password.PasswordEncoder;

// 2.1.4.1. セッターインジェクション UserServiceの実装例
public class SetterInjectionUserServiceImpl implements UserService {

	private UserRepository userRepository;
	
    private PasswordEncoder passwordEncoder;

    // デフォルトコンストラクタ(省略可)
    public SetterInjectionUserServiceImpl() {
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
	
	public void register(User user, String rawPassword) {
		System.out.println("SetterInjectionUserServiceImpl register 実行: User registration");
		if (this.userRepository.countByUsername(user.getUsername()) > 0) {
			// ユーザー名がすでに使用されていたら例外をスローする
			throw new UserAlreadyRegisteredException();
		}
		// 生パスワードをハッシュ化して設定
		user.setPassword(this.passwordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}

}
