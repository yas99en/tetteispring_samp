package com.example.domain.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Staff implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer joinedYear;

	public Integer getJoinedYear() {
		return joinedYear;
	}

	public void setJoinedYear(Integer joinedYear) {
		this.joinedYear = joinedYear;
	}
	
}
