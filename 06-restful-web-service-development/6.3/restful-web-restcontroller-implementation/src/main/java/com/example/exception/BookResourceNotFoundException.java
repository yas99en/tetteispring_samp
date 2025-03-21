package com.example.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

// 6.3.3.5. リソースの削除 「404 Not Found」を応答するための例外クラスの実装例
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookResourceNotFoundException(String bookId) {
		super("Book is not found (bookId = " + bookId + ")");
	}
}
