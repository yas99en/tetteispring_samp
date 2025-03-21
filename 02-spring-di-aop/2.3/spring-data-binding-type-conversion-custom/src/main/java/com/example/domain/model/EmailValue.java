package com.example.domain.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

// 2.3.6. Type Conversionのカスタマイズ 独自クラス(メールアドレスを表現するクラス)
public class EmailValue {
	
	@Size(max = 256)
	@Email
	private String value;
	
	public void setValue(String value) { this.value = value; }
	public String getValue() { return value; }
	public String toString() { return getValue(); }
	
}