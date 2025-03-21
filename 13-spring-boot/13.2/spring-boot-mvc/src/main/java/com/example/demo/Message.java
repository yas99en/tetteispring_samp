package com.example.demo;

import java.io.Serializable;

// 13.2.1. RESTful Webサービスの作成 メッセージを保持するクラスの実装例
public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
