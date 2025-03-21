package com.example.demo.domain.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.service.exception.UserAlreadyRegisteredException;
import com.example.demo.domain.service.password.PasswordEncoder;

// UserServiceImplはAppConfigでBean定義している
public class UserServiceImpl implements UserService, InitializingBean, DisposableBean {
	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public void register(User user, String rawPassword) {
		if (this.userRepository.countByUsername(user.getUsername()) > 0) {
			// ユーザー名がすでに使用されていたら例外をスローする
			throw new UserAlreadyRegisteredException();
		}
		// 生パスワードをハッシュ化して設定
		user.setPassword(this.passwordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}
	
	// 2.1.8.1.3. Post Construct @PostConstructアノテーションの実装例
	@PostConstruct
	void populateCache() {
		// キャッシュ作成処理、本書では省略
		System.out.println("UserServiceImpl populateCache 実行: キャッシュ作成処理");
	}

	// 2.1.8.1.3. Post Construct InitializingBeanの実装例
	@Override
	public void afterPropertiesSet() {
		// キャッシュ作成処理、本書では省略
		System.out.println("UserServiceImpl afterPropertiesSet 実行: キャッシュ作成処理");
	}
	
	// 2.1.8.1.3. Post Construct Java Configの場合
	void populateCacheInitMethod() {
		// キャッシュ作成処理、本書では省略
		System.out.println("UserServiceImpl populateCacheInitMethod 実行: キャッシュ作成処理");
	}
	
	// 2.1.8.2.1. Pre Destroy @PreDestroyアノテーションの実装例
	@PreDestroy
	void clearCache() {
		// キャッシュ破棄処理、本書では省略
		System.out.println("UserServiceImpl clearCache 実行: キャッシュ破棄処理");
	}
	
	// 2.1.8.2.1. Pre Destroy DisposableBeanインターフェイスの実装例
	@Override
	public void destroy() {
		// キャッシュ破棄処理、本書では省略
		System.out.println("UserServiceImpl destroy 実行: キャッシュ破棄処理");
	}
	
	// 2.1.8.2.1. Pre Destroy Java Configの場合
	void clearCacheDestroyMethod() {
		// キャッシュ破棄処理、本書では省略
		System.out.println("UserServiceImpl clearCacheDestroyMethod 実行: キャッシュ破棄処理");
	}
	
}
