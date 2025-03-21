package com.example.domain.model;

import java.io.Serializable;

public class Properties implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String profile;
	
	public Properties(String profile) {
		this.profile = profile;
	}
	
	public String getProfileString() {
		return profile;
	}
	
}
