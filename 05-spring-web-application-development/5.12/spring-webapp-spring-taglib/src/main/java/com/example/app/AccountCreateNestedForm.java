package com.example.app;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class AccountCreateNestedForm implements Serializable { 
	private static final long serialVersionUID = 1L;
	
	@Past
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date dateOfBirthNested;
	
	public Date getDateOfBirthNested() {
		return dateOfBirthNested;
	}

	public void setDateOfBirthNested(Date dateOfBirthNested) {
		this.dateOfBirthNested = dateOfBirthNested;
	}
		
}