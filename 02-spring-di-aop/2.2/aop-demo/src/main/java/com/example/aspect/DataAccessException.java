package com.example.aspect;

public class DataAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataAccessException(RuntimeException e) {
		super(e);
	}
	
}
