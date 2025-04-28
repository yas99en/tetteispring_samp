package com.example.app;

import java.io.Serializable;

import jakarta.validation.constraints.Size;
import jakarta.validation.groups.Default;

public class AccountCreateForm implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	public interface FreeAccount extends Default {}
	public interface PayAccount extends Default {}
	
	@Size(min = 1, max = 1) 
	private String type;

	private String cardNo;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
		
}
