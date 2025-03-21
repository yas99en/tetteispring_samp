package com.example.app;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

// 5.7.7 入力チェックルールの切替用フォーム
public class AccountSwitchCheckForm {
	
	interface FreeAccount extends Default {}
	interface PayAccount extends Default {}
	
	@Size(min = 1, max = 1) 
	private String type;

	// 無料会員は未入力、有料会員は14〜16桁のチェック
	@NotNull(groups = PayAccount.class)
	@Size(max = 0, groups = FreeAccount.class)
	@Size(min = 14, max = 16, groups = PayAccount.class)
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
