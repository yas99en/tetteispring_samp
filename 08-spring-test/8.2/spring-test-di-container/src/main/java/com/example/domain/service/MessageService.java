package com.example.domain.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

// 8.2.1. Beanの単体テスト 固定のメッセージを返却するクラス
// 8.2.1. Beanの単体テスト MessageSourceからメッセージを取得するクラス
@Service
public class MessageService {

	@Autowired
	MessageSource messageSource;
	
	public String getMessage() {
		return "Hello!!";
	}
	
	public String getMessageByCode(String code) {
		return messageSource.getMessage(code, null, Locale.getDefault());
	}
	
}
