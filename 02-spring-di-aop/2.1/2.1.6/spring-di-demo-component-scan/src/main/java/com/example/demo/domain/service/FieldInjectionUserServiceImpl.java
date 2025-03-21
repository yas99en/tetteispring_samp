package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.service.exception.UserAlreadyRegisteredException;
import com.example.demo.domain.service.password.PasswordEncoder;

// ビジネスロジック(ビジネスルール)を提供するコンポーネントであることを示すアノテーション
@Service("fieldInjectionUserService")
public class FieldInjectionUserServiceImpl implements UserService {

	@Autowired
    UserRepository userRepository;
	
    @Autowired
    PasswordEncoder passwordEncoder;
    
	public void register(User user, String rawPassword) {
		System.out.println("FieldInjectionUserServiceImpl register 実行: User registration");
		if (this.userRepository.countByUsername(user.getUsername()) > 0) {
			// ユーザー名がすでに使用されていたら例外をスローする
			throw new UserAlreadyRegisteredException();
		}
		// 生パスワードをハッシュ化して設定
		user.setPassword(this.passwordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}

}
