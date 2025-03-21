package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.config.Exclude;
import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.service.exception.UserAlreadyRegisteredException;
import com.example.demo.domain.service.password.PasswordEncoder;

// 2.1.6.2. フィルタを明示したコンポーネントスキャン スキャン対象から除外するコンポーネントを指定するための設定例(Java Configの場合)
// このクラスはスキャン対象から除外される
@Exclude
// ビジネスロジック(ビジネスルール)を提供するコンポーネントであることを示すアノテーション
@Service("setterInjectionUserService")
public class SetterInjectionUserServiceImpl implements UserService {

	private UserRepository userRepository;
	
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
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
