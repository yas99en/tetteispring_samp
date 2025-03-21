package com.example.app.api.book;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookResource implements Serializable {
	public static class Publisher implements Serializable {
		private static final long serialVersionUID = 1L;
		private String name;
		private String tel;

		public Publisher() {
			/* default constructor is required for Jackson to deserialize */
		}

		public Publisher(String name, String tel) {
			this.name = name;
			this.tel = tel;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

	}

	private static final long serialVersionUID = 1L;

	private String bookId;
	@NotBlank
	private String name;
	private List<String> authors;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate publishedDate;
	private Publisher publisher;

	public BookResource() {
		/* default constructor is required for Jackson to deserialize */
	}

	public BookResource(String bookId, @NotBlank String name,
			List<String> authors, LocalDate publishedDate,
			Publisher publisher) {
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
