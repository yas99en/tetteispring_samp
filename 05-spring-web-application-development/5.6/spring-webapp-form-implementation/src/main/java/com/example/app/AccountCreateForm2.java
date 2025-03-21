package com.example.app;

import java.io.Serializable;

public class AccountCreateForm2 implements Serializable {
	private static final long serialVersionUID = 1L;
	private AccountForm account; 
	private CardForm card;
	
	public AccountForm getAccount() {
		return account;
	}
	public void setAccount(AccountForm account) {
		this.account = account;
	}
	public CardForm getCard() {
		return card;
	}
	public void setCard(CardForm card) {
		this.card = card;
	}

	
}
