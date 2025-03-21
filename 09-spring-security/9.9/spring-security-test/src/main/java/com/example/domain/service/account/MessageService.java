package com.example.domain.service.account;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.domain.model.Message;


@Service
public class MessageService {
	
	// 9.9.3.1. アノテーションを使用した認証情報のセットアップ テスト対象のメソッドの実装例
	@PreAuthorize("hasRole('ADMIN')") // 管理者ユーザーのみアクセスできるメソッド
	public Message create(String message) {
		Message msg = new Message();
		msg.setText(message);
		return msg;
	}
}
