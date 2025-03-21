package com.example.app;

import java.io.Serializable;

import com.example.validation.AlphaNumeric;
import com.example.validation.Password;

// 5.7.6 入力チェックルールの追加用フォーム
public class AccountOriginalAnnotationCheckForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// 既成ルールを合成して作成する方法
	@AlphaNumeric
	private String couponCode;

	// 独自のバリデータを実装して作成する方法
	@Password
	private String password;
	
	public String getCouponCode() {
		return couponCode;
	}
	
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
