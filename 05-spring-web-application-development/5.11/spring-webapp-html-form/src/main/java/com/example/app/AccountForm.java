package com.example.app;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class AccountForm implements Serializable { 
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String opinionsAndRequests;
	private String hobbies;
	private Boolean agreement;
	private String gender;
	private String livingPrefecture;
	
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

	public String getOpinionsAndRequests() {
		return opinionsAndRequests;
	}

	public void setOpinionsAndRequests(String opinionsAndRequests) {
		this.opinionsAndRequests = opinionsAndRequests;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public Boolean getAgreement() {
		return agreement;
	}

	public void setAgreement(Boolean agreement) {
		this.agreement = agreement;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLivingPrefecture() {
		return livingPrefecture;
	}

	public void setLivingPrefecture(String livingPrefecture) {
		this.livingPrefecture = livingPrefecture;
	}
		
}
