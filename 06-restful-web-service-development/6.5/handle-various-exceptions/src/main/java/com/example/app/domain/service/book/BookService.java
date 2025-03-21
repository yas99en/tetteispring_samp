package com.example.app.domain.service.book;

import java.util.Collection;

import com.example.app.domain.model.Book;

public interface BookService {
	Collection<Book> findAll();

	Book find(String bookId);

	Book create(Book book);

	Book update(Book book);

	Book delete(String bookId);

}
