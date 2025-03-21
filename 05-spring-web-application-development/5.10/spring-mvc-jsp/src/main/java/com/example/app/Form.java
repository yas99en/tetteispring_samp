package com.example.app;

import java.io.Serializable;

public class Form implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String memo;

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
