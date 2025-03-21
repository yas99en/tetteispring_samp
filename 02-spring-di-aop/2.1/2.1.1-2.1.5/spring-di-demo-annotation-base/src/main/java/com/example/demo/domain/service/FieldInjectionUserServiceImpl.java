package com.example.demo.domain.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.service.collection.IF;
import com.example.demo.domain.service.exception.UserAlreadyRegisteredException;
import com.example.demo.domain.service.password.PasswordEncoder;

// 2.1.3.3. アノテーションベースConfiguration Bean名を明示的に指定するアノテーションベースConfigurationによるBean定義の実装例
// 2.1.4.3. フィールドインジェクション フィールドインジェクションを行なうアノテーションベースConfigurationの実装例
// 明示的にBean名を"fieldInjectionUserService"に指定
@Component("fieldInjectionUserService")
public class FieldInjectionUserServiceImpl implements UserService {

	@Autowired
    UserRepository userRepository;
	
    @Autowired
    PasswordEncoder passwordEncoder;

    // 2.1.5.3. コレクションやマップ型のオートワイヤリング IF<Integer>インターフェイスを実装したBeanをすべて取得する実装例
    @Autowired
    List<IF<Integer>> ifList;
    // 2.1.5.3. コレクションやマップ型のオートワイヤリング IF<Integer>インターフェイスを実装したBeanをすべて取得する実装例
    @Autowired
    Map<String, IF<Integer>> ifMap;
	
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
