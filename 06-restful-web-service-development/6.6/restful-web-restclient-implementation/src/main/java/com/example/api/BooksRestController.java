package com.example.api;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.domain.dto.BookResource;
import com.example.domain.dto.BookResourceQuery;
import com.example.domain.model.Book;
import com.example.domain.model.BookCriteria;
import com.example.domain.service.BookService;
import com.example.exception.BookResourceNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("books")
public class BooksRestController {
	
	BookService bookService;
	
	public BooksRestController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@CrossOrigin(maxAge = 900) 
	@GetMapping(path = "{bookId}") 
	public BookResource getBook(@PathVariable String bookId) {
		
		Book book = bookService.find(bookId); 
		// 書籍情報がない場合は例外をスローする
		if (book == null) {
			throw new BookResourceNotFoundException(bookId);
		}
		BookResource resource = new BookResource(); 
		resource.setBookId(book.getBookId());
		resource.setName(book.getName());
		resource.setPublishedDate(book.getPublishedDate());
		return resource; 
	}
	
	@PostMapping
	public ResponseEntity<Book> createBook(
			@Validated @RequestBody BookResource newResource,
			UriComponentsBuilder uriBuilder) { 
		
//		// 6.6.5. タイムアウトの指定を検証したい場合はコメントアウトを外してください。
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//		}
		
		Book newBook = new Book(); 
		newBook.setName(newResource.getName());
		newBook.setPublishedDate(newResource.getPublishedDate());
		
		Book createdBook = bookService.create(newBook); 

		URI resourceUri = MvcUriComponentsBuilder.relativeTo(uriBuilder) 
				.withMethodCall(
						MvcUriComponentsBuilder.on(BooksRestController.class).getBook(createdBook.getBookId()))
				.build().encode().toUri();		
		
		return ResponseEntity.created(resourceUri).body(newBook); 
	}
	
	@PutMapping(path = "{bookId}") 
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void put(@PathVariable String bookId,
			@Validated @RequestBody BookResource resource) {
		
		Book book = new Book();
		book.setBookId(bookId);
		book.setName(resource.getName());
		book.setPublishedDate(resource.getPublishedDate());
		
		bookService.update(book); 
	}
	
	@DeleteMapping(path = "{bookId}") 
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void delete(@PathVariable String bookId) {
		bookService.delete(bookId); 
	}
	
	@GetMapping 
	public List<BookResource> searchBooks(@Validated BookResourceQuery query) {
		
		BookCriteria criteria = new BookCriteria();
		criteria.setName(query.getName());
		criteria.setPublishedDate(query.getPublishedDate());
		
		List<Book> books = bookService.findAllByCriteria(criteria);
		
		return books.stream().map(book -> {
			BookResource resource = new BookResource();
			resource.setBookId(book.getBookId());
			resource.setName(book.getName());
			resource.setPublishedDate(book.getPublishedDate());
			return resource;
		}).collect(Collectors.toList()); 
	}
	
	@GetMapping(path = "{bookId}", params={"username","password"}) 
	public BookResource getBookByParams(@PathVariable String bookId, @RequestParam(value="username") String username, @RequestParam(value="password") String password) {
		Book book = bookService.find(bookId); 
		// 書籍情報がない場合は例外をスローする
		if (book == null) {
			throw new BookResourceNotFoundException(bookId);
		}
		BookResource resource = new BookResource(); 
		resource.setBookId(book.getBookId());
		resource.setName(book.getName());
		resource.setPublishedDate(book.getPublishedDate());
		System.out.println("username : "+username+" password : "+password);
		return resource; 
	}
}
