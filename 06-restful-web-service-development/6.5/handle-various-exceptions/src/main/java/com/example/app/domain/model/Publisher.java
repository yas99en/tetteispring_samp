package com.example.app.domain.model;

import java.io.Serializable;

public class Publisher implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String tel;

	public Publisher(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

}
