package com.example.app;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

// 5.7.4 入力チェックルールの指定用フォーム
public class AccountInputValueCheckForm implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// 必須チェック
	@NotNull
	private String item1;
	
	// 桁数(サイズ)チェック
	@Size(max = 50)
	private String item2;
	
	// 文字種チェック
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String item3;
	
	//　数値の範囲チェック
	@Min(1)
	@Max(100)
	private int item4;
	
	// 日時の妥当性チェック
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate item5;
	
	// 真偽値チェック
	@AssertTrue
	private boolean item6;
	
	// 数値の範囲チェック
	@Digits(integer = 2, fraction = 2)
	private BigDecimal item7;
	
	public String getItem1() {
		return item1;
	}
	
	public void setItem1(String item1) {
		this.item1 = item1;
	}
	
	public String getItem2() {
		return item2;
	}
	
	public void setItem2(String item2) {
		this.item2 = item2;
	}
	
	public String getItem3() {
		return item3;
	}
	
	public void setItem3(String item3) {
		this.item3 = item3;
	}
	
	public int getItem4() {
		return item4;
	}
	
	public void setItem4(int item4) {
		this.item4 = item4;
	}
	
	public LocalDate getItem5() {
		return item5;
	}
	
	public void setItem5(LocalDate item5) {
		this.item5 = item5;
	}
	
	public boolean getItem6() {
		return item6;
	}
	
	public void setItem6(boolean item6) {
		this.item6 = item6;
	}
	
	public BigDecimal getItem7() {
		return item7;
	}
	
	public void setItem7(BigDecimal item7) {
		this.item7 = item7;
	}
	
}
