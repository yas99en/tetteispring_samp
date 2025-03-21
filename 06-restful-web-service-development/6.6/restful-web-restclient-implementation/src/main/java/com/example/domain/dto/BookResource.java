package com.example.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

// 6.6.3.1. リソースクラスの実装例
public class BookResource implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bookId;
	private String name;

	@JsonFormat(pattern = "yyyy-MM-dd") // ISO 8061の拡張形式(yyyy-MM-dd)の指定を追加
	private LocalDate publishedDate;
	
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
	
	public LocalDate getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	@Override
	public String toString() {
		String format = "%s:[bookId=%s, name=%s, publishedDate=%s]";
		return String.format(format, 
				BookResource.class.getName(), 
				this.bookId, 
				this.name, 
				this.publishedDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
	}
}
