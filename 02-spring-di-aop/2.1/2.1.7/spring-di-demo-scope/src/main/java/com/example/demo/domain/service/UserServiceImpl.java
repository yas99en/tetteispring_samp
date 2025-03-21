package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.service.exception.UserAlreadyRegisteredException;
import com.example.demo.domain.service.password.PasswordEncoder;

// 2.1.7.2.1. ルックアップメソッドインジェクション ルックアップメソッドインジェクションを利用したBeanの取得の実装例
@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void register(User user, String rawPassword) {
		PasswordEncoder passwordEncoder = passwordEncoder();
		if (this.userRepository.countByUsername(user.getUsername()) > 0) {
			// ユーザー名がすでに使用されていたら例外をスローする
			throw new UserAlreadyRegisteredException();
		}
		// 生パスワードをハッシュ化して設定
		user.setPassword(passwordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}
	
	@Lookup(value="passwordEncoder")
	public PasswordEncoder passwordEncoder() {
		return null; // 戻り値はダミーでよい
	}

}
