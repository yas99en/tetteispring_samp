package com.example.app;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BookResource;
import com.example.dto.BookResource1;

@RestController
public class BookRestController {

	@PostMapping("books")
	public BookResource createBook(@RequestBody BookResource newResource) {
		BookResource bookResource = new BookResource();
		bookResource.setBookId("3afd8c2a-82bb-11e5-8bcf-feff819cdc9f");
		bookResource.setName(newResource.getName());
		bookResource.setAuthors(newResource.getAuthors());
		bookResource.setPublishedDate(LocalDate.now());
		com.example.dto.BookResource.Publisher publisher = new com.example.dto.BookResource.Publisher();
		publisher.setName(newResource.getPublisher().getName());
		publisher.setTel(newResource.getPublisher().getTel());
		bookResource.setPublisher(publisher);
		return bookResource;
	}

	@PostMapping("books1")
	public BookResource1 createBookDateFmt(@RequestBody BookResource newResource) {
		BookResource1 bookResource = new BookResource1();
		bookResource.setBookId("3afd8c2a-82bb-11e5-8bcf-feff819cdc9f");
		bookResource.setName(newResource.getName());
		bookResource.setAuthors(newResource.getAuthors());
		bookResource.setPublishedDate(LocalDate.now());
		com.example.dto.BookResource1.Publisher publisher = new com.example.dto.BookResource1.Publisher();
		publisher.setName(newResource.getPublisher().getName());
		publisher.setTel(newResource.getPublisher().getTel());
		bookResource.setPublisher(publisher);
		return bookResource;
	}
}
