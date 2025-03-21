package com.example.app;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

public class AccountCreateSmartForm implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	public interface FreeAccount extends Default {}
	public interface PayAccount extends Default {}
	
	@Size(min = 1, max = 1) 
	private String type;

	@NotNull(groups = PayAccount.class)
	@Size(max = 0, groups = FreeAccount.class, message = "一般会員の場合はカード番号を入力しないでください。")
	@Size(min = 14, max = 16, groups = PayAccount.class, message = "カード番号は14〜16桁で入力してください。")
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
