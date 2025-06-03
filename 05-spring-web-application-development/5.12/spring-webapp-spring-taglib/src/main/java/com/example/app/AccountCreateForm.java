package com.example.app;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class AccountCreateForm implements Serializable { 
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Size(min = 6, max = 8)
	private String name;
	
	@Past
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date dateOfBirth;
	
	@Valid
	private AccountCreateNestedForm accountCreateNestedForm;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // yyyy-MM-dd形式
	private Date departureDate;
	
	private String defaultHtmlEscapeStr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public AccountCreateNestedForm getAccountCreateNestedForm() {
		return accountCreateNestedForm;
	}

	public void setAccountCreateNestedForm(AccountCreateNestedForm accountCreateNestedForm) {
		this.accountCreateNestedForm = accountCreateNestedForm;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getDefaultHtmlEscapeStr() {
		return defaultHtmlEscapeStr;
	}

	public void setDefaultHtmlEscapeStr(String defaultHtmlEscapeStr) {
		this.defaultHtmlEscapeStr = defaultHtmlEscapeStr;
	}

}