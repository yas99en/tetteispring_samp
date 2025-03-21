package com.example.domain.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// 8.2.7. テスト用のプロパティ値の指定 プロパティ値を直接指定する際の定義例
@Service
public class AuthenticationService {

	@Value("${auth.failureCountToLock:5}")
	int failureCountToLock;
	
	public int getFailureCountToLock() {
		return failureCountToLock;
	}

}
