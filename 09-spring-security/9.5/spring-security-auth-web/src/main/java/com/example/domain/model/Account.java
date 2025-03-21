package com.example.domain.model;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private List<Role> roles;

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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public boolean isAdmin() {
		for (Role role : roles) {
			if (role.getId() == 2) {
				return true;
			}
		}
		return false;
	}
}
