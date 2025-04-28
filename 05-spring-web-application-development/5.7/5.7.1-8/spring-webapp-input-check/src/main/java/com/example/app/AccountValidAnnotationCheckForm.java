package com.example.app;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;

// 5.7.5 ネストしたJavaBeans の入力チェック用フォーム
public class AccountValidAnnotationCheckForm implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotNull
	private String item;
	
	public String getItem() {
		return item;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
}
