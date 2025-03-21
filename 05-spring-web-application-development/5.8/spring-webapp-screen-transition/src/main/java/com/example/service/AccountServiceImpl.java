package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Override
	public Account create(String name) {
		return new Account(name);
	}
	
	@Override
	public Account findOne(String accountId) {
		return new Account(accountId, "dummy user");
	}

}
