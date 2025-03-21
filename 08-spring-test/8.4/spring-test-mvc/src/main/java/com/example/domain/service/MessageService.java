package com.example.domain.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	private final MessageSource messageSource;
	
	@Autowired
	public MessageService(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	// 8.2.1. DIコンテナ管理のBeanに対するテスト 固定のメッセージを返却するクラス
	public String getMessage() {
		return "Hello!!";
	}
	
	// 8.2.1. DIコンテナ管理のBeanに対するテスト MessageSourceからメッセージを取得するクラス
	public String getMessageByCode(String code) {
		return messageSource.getMessage(code, null, Locale.getDefault());
	}
	
}
