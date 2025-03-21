package com.example.form;

import java.io.Serializable;

import javax.validation.Valid;

public class AccountCreateForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private String password;
	private String confirmPassword;

	@Valid
	private AccountForm accountForm;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public AccountForm getAccountForm() {
		return accountForm;
	}

	public void setAccountForm(AccountForm accountForm) {
		this.accountForm = accountForm;
	}
}