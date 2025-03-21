package com.example.demo.domain.service.exception;

public class UserAlreadyRegisteredException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserAlreadyRegisteredException() {
		super();
	}
	
	public UserAlreadyRegisteredException(String s) {
		super(s);
	}
	
}
