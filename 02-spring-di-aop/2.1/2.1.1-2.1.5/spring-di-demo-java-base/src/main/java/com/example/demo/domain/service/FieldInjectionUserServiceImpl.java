package com.example.demo.domain.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.service.collection.IF;
import com.example.demo.domain.service.exception.UserAlreadyRegisteredException;
import com.example.demo.domain.service.password.Lightweight;
import com.example.demo.domain.service.password.PasswordEncoder;

// フィールドインジェクション
public class FieldInjectionUserServiceImpl implements UserService {

	@Autowired
    UserRepository userRepository;
	
	// 2.1.5.1. 型によるオートワイヤリング 作成した@Lightweightアノテーションを付与したフィールドインジェクションの実装例
    @Autowired
    @Lightweight
    PasswordEncoder passwordEncoder;

    // 2.1.5.3. コレクションやマップ型のオートワイヤリング @Autowiredアノテーションによるインジェクション
    @Autowired 
    @Qualifier("ifList")
    List<IF<?>> ifList;
    
	// 2.1.5.3. コレクションやマップ型のオートワイヤリング @Autowiredアノテーションによるインジェクション
    @Autowired 
    @Qualifier("ifMap")
    Map<String, IF<?>> ifMap;
	
	public void register(User user, String rawPassword) {
		System.out.println("FieldInjectionUserServiceImpl register 実行: User registration");
		System.out.println("ifList: インジェクションできているかオブジェクトを確認する");
		ifList.forEach(value -> System.out.println(value.getClass().getName()));
		System.out.println("ifMap: インジェクションできているかオブジェクトを確認する");
		ifMap.forEach((key, value) -> System.out.println(key + ", " + value.getClass().getName()));
		if (this.userRepository.countByUsername(user.getUsername()) > 0) {
			// ユーザー名がすでに使用されていたら例外をスローする
			throw new UserAlreadyRegisteredException();
		}
		// 生パスワードをハッシュ化して設定
		user.setPassword(this.passwordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}

}
