package com.example.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

	private final Authenticator authenticator;
	
	@Autowired
	public AuthenticationService(Authenticator authenticator) {
		this.authenticator = authenticator;
	}
	
	public void check() {
		System.out.println("認証成功する場合");
		if (authenticator.authenticate("correct-username", "correct-password")) {
			System.out.println("認証に成功しました");
		} else {
			System.out.println("認証に失敗しました");
		}
		
		System.out.println("認証を10回試して10回とも失敗する場合");
		for(int i = 0; i < 10; i++) {
			if (authenticator.authenticate("username", "password")) {
				System.out.println("認証に成功しました");
			} else {
				System.out.println("認証に失敗しました");
			}
		}
		
		System.out.println("ロック後に認証を試みる場合");
		if (authenticator.authenticate("correct-username", "correct-password")) {
			System.out.println("認証に成功しました");
		} else {
			System.out.println("認証に失敗しました");
		}
	}
	
}
