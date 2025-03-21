package com.example.app;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CardForm implements Serializable {
	private static final long serialVersionUID = 1L; 
	private String no;
	
	@DateTimeFormat(pattern = "yyyy/MM") 
	private Date validMonth;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Date getValidMonth() {
		return validMonth;
	}

	public void setValidMonth(Date validMonth) {
		this.validMonth = validMonth;
	}

}