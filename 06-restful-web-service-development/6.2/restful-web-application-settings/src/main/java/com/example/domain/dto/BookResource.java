package com.example.domain.dto;

import java.io.Serializable;

public class BookResource implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bookId;
	private String name;
	private String publishedDate;
	
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
	
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
}
