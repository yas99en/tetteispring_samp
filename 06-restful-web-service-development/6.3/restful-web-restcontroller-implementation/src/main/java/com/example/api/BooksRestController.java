package com.example.api;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

// 6.3.4.2. Controller/Handlerメソッド単位の設定 @CrossOriginを使用した場合のControllerクラスの実装例
@CrossOrigin
// 6.3.2. Controllerクラスの作成 Controllerクラスの実装例
@RestController
@RequestMapping("books")
public class BooksRestController {

	@Autowired
	BookService bookService;
	@CrossOrigin(maxAge = 900)
	// 6.3.3.2. Bookリソースの取得 リソースの取得用のREST APIの実装例
	@GetMapping(path = "{bookId}") 
	public BookResource getBook(@PathVariable String bookId) {
		// 6.3.3.5. リソースの削除 Bookリソースを取得するREST API(getBook)の変更点
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

	// 6.3.3.3. リソースの作成 リソースの作成用のREST APIの実装例
	@PostMapping
	public ResponseEntity<Void> createBook(
			@Validated @RequestBody BookResource newResource,
			UriComponentsBuilder uriBuilder) { 

		Book newBook = new Book(); 
		newBook.setName(newResource.getName());
		newBook.setPublishedDate(newResource.getPublishedDate());

		Book createdBook = bookService.create(newBook); 
		// 6.3.5.2. MvcUriComponentsBuilderを利用したURIの生成 MvcUriComponentsBuilderを使用したURIの生成例
		URI resourceUri = MvcUriComponentsBuilder.relativeTo(uriBuilder) 
				.withMethodCall(
						MvcUriComponentsBuilder.on(BooksRestController.class).getBook(createdBook.getBookId()))
				.build().encode().toUri();

		return ResponseEntity.created(resourceUri).build(); 
	}

	// 6.3.3.4. リソースの更新 リソースの更新用のREST APIの実装例
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

	// 6.3.3.5. リソースの削除 リソースの削除用のREST APIの実装例
	@DeleteMapping(path = "{bookId}") 
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void delete(@PathVariable String bookId) {
		bookService.delete(bookId); 
	}

	// 6.3.3.6. リソースの検索 Bookリソースを検索するREST APIの実装例
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
}
