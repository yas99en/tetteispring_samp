package com.example.app.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	private String bookId;
	private String name;
	private List<String> authors;
	private LocalDate publishedDate;
	private Publisher publisher;

	public Book(String bookId, String name, List<String> authors, LocalDate publishedDate, Publisher publisher) {
		this.bookId = bookId;
		this.name = name;
		this.authors = authors;
		this.publishedDate = publishedDate;
		this.publisher = publisher;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
}
