package com.example.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

// 6.3.3.1. リソースクラスの作成 本節の説明で扱うリソースクラスの実装例
public class BookResource implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bookId;
	private String name;

	// 6.3.3.2. Bookリソースの取得 @JsonFormatを使用したフォーマットの指定例
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
}
