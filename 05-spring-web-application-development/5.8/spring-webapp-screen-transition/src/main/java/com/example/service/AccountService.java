package com.example.service;

import com.example.model.Account;

public interface AccountService {

	public Account create(String name);
	public Account findOne(String accountId);
	
}