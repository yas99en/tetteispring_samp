package com.example.app;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class AccountCreateForm1 implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotNull 
	@Size(min = 1, max = 50)
	private String name;
	
	@NotNull
	@Size(min = 9, max = 11)
	private String tel;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd") 
	private Date dateOfBirth;
	
	@NotNull
	@Size(min = 9, max = 256) 
	private String email;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

