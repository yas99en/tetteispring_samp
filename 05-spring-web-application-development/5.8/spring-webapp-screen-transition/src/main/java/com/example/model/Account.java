package com.example.model;

import java.util.UUID;

public class Account {
	
	private String accountId;

	private String name;
	
	public Account(String name) {
		this.name = name;
		
		// サンプルのためのダミーデータ
		this.accountId = UUID.randomUUID().toString();
	}
	
	public Account(String accountId, String name) {
		this.accountId = accountId;
		this.name = name;
	}
	
	public String getAccountId() {
		return this.accountId;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}