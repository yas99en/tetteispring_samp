package com.example.domain.service;

import org.springframework.stereotype.Component;

import com.example.aspect.DataAccessException;
import com.example.domain.model.User;

@Component
public class UserServiceImpl implements UserService {

	// @AfterReturningを用いたPointcutの指定例（戻り値を利用する場合）の確認用メソッド
	public User findOne(String username) {
		// 対象のuserの検索処理、ここでは省略
		System.out.println("UserServiceImpl findOne 実行");
		User user = new User();
		user.setUsername(username);
		return user;
	}

	// @AfterThrowingを用いたPointcutの指定例の確認用メソッド
	@Override
	public void checkOccuredExcetion() throws RuntimeException {
		System.out.println("UserServiceImpl checkOccuredExcetion 実行");
		throw new RuntimeException();
	}

	// @AfterThrowingを用いた例外の変換の確認用メソッド
	@Override
	public void checkOccuredDataAccessException() throws DataAccessException {
		System.out.println("UserServiceImpl checkOccuredDataAccessException 実行");
		throw new DataAccessException(new RuntimeException());
	}
	
}