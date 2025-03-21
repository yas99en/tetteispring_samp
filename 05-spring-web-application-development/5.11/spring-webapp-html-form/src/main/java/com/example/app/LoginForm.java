package com.example.app;

import java.io.Serializable;
import org.springframework.stereotype.Component;

@Component
public class LoginForm implements Serializable { 
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
