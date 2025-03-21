package com.example.app;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Size(min = 0, max = 10)
	private String name;
	
	@NotNull(message = "{validation.errors.required}")
	private String defaultMessage;
	
	@NotNull(message = "入力してください。(エラーメッセージをmessage属性に直接指定する定義例)")
	private String directMessage;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}
	
	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}
	
	public String getDirectMessage() {
		return directMessage;
	}
	
	public void setDirectMessage(String directMessage) {
		this.directMessage = directMessage;
	}

}
