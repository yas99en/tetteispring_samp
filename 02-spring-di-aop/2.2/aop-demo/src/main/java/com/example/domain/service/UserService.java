package com.example.domain.service;

import com.example.aspect.DataAccessException;
import com.example.domain.model.User;

public interface UserService {
	
	// @AfterReturningを用いたPointcutの指定例（戻り値を利用する場合）の確認用メソッド
	User findOne(String username);
	
	// @AfterThrowingを用いたPointcutの指定例の確認用メソッド
	void checkOccuredExcetion() throws RuntimeException;
	
	// @AfterThrowingを用いた例外の変換の確認用メソッド
	void checkOccuredDataAccessException() throws DataAccessException;
	
}
