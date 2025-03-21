package com.example.app.domain.service.book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.app.domain.model.Book;
import com.example.app.domain.model.Publisher;

@Service
public class BookServiceImpl implements BookService {
	private final Map<String, Book> bookRepository = new ConcurrentHashMap<>();

	@PostConstruct
	public void loadDummyData() {
		List<String> authors = new ArrayList<>();
		authors.add("John Doe");
		authors.add("et al.");
		Publisher publisher = new Publisher("Some Publisher", "0000-000-000");
		Book book = new Book("00000000-0000-0000-0000-000000000000",
				"Some Book", authors, LocalDate.of(2024, 4, 20), publisher);
		bookRepository.put(book.getBookId(), book);
	}

	public Collection<Book> findAll() {
		return bookRepository.values();
	}

	public Book find(String bookId) {
		if (bookId.equals("runtime-exception")) {
			throw new RuntimeException();
		}
		return bookRepository.get(bookId);
	}

	public Book create(Book book) {
		String bookId = UUID.randomUUID().toString();
		book.setBookId(bookId);
		bookRepository.put(bookId, book);
		return book;
	}

	public Book update(Book book) {
		return bookRepository.put(book.getBookId(), book);
	}

	public Book delete(String bookId) {
		return bookRepository.remove(bookId);
	}
}
