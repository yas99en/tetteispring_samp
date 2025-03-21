package com.example.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookResourceNotFoundException(String bookId) {
		super("Book is not found (bookId = " + bookId + ")");
	}
}
