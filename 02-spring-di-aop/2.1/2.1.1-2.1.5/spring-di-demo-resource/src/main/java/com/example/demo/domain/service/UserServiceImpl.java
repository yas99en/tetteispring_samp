package com.example.demo.domain.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.service.collection.IF;
import com.example.demo.domain.service.exception.UserAlreadyRegisteredException;
import com.example.demo.domain.service.password.PasswordEncoder;

public class UserServiceImpl implements UserService {
	
	// 2.1.5.3. コレクションやマップ型のオートワイヤリング Resourceアノテーションによるインジェクション 
    @Resource
	List<IF<?>> ifList;
    
    // 2.1.5.3. コレクションやマップ型のオートワイヤリング Resourceアノテーションによるインジェクション 
    @Resource
	Map<String, IF<?>> ifMap;
	
    // 2.1.5.2. 名前によるオートワイヤリング フィールド名がBean名に一致する例
 	@Resource
    PasswordEncoder sha256PasswordEncoder;
    
    private UserRepository userRepository;
    
    // 2.1.5.2. 名前によるオートワイヤリング プロパティ名がBean名に一致する例
	@Resource
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	public void register(User user, String rawPassword) {
		System.out.println("ifList: インジェクションできているかオブジェクトを確認する");
		ifList.forEach(value -> System.out.println(value.getClass().getName()));
		System.out.println("ifMap: インジェクションできているかオブジェクトを確認する");
		ifMap.forEach((key, value) -> System.out.println(key + ", " + value.getClass().getName()));
		if (this.userRepository.countByUsername(user.getUsername()) > 0) {
			// ユーザー名がすでに使用されていたら例外をスローする
			throw new UserAlreadyRegisteredException();
		}
		// 生パスワードをハッシュ化して設定
		user.setPassword(this.sha256PasswordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}

}
