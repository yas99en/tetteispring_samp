package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.service.exception.UserAlreadyRegisteredException;
import com.example.demo.domain.service.password.PasswordEncoder;

// フィールドインジェクション
public class NullableUserServiceImpl implements UserService {

	@Autowired
    UserRepository userRepository;
	
	// 2.1.5.1. 型によるオートワイヤリング @Nullableを用いたフィールドインジェクションの実装例
    @Autowired
    @Nullable
    PasswordEncoder passwordEncoder;

	public void register(User user, String rawPassword) {
		// passwordEncoderがnullだった場合は、生パスワードをそのまま返す
		String encodedPassword = (passwordEncoder != null) ? passwordEncoder.encode(rawPassword) : rawPassword;
		if (this.userRepository.countByUsername(user.getUsername()) > 0) {
			// ユーザー名がすでに使用されていたら例外をスローする
			throw new UserAlreadyRegisteredException();
		}
		// 生パスワードをハッシュ化して設定
		user.setPassword(encodedPassword);
		this.userRepository.save(user);
	}

}
