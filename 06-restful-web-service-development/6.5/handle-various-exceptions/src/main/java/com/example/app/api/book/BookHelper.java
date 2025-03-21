package com.example.app.api.book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.api.BookNotFoundException;
import com.example.app.domain.model.Book;
import com.example.app.domain.model.Publisher;
import com.example.app.domain.service.book.BookService;

@Service
public class BookHelper {
	private BookService bookService;

	@Autowired
	public BookHelper(BookService bookService) {
		this.bookService = bookService;
	}

	private static BookResource.Publisher resourceFromModel(Publisher model) {
		return new BookResource.Publisher(model.getName(), model.getTel());
	}

	private static BookResource resourceFromModel(Book model) {
		return new BookResource(model.getBookId(),
				model.getName(), model.getAuthors(), model.getPublishedDate(),
				resourceFromModel(model.getPublisher()));
	}

	private static Publisher modelFromResource(
			BookResource.Publisher resource) {
		return new Publisher(resource.getName(), resource.getTel());
	}

	private static Book modelFromResource(BookResource resource) {
		return new Book(resource.getBookId(), resource.getName(),
				resource.getAuthors(), resource.getPublishedDate(),
				modelFromResource(resource.getPublisher()));
	}

	public List<BookResource> getBooks() {
		Collection<Book> books = bookService.findAll();
		List<BookResource> bookResources = new ArrayList<>();
		for (Book book : books) {
			bookResources.add(resourceFromModel(book));
		}
		return bookResources;
	}

	public BookResource getBook(String bookId) {
		Book book = bookService.find(bookId);
		if (book == null) {
			throw new BookNotFoundException(bookId);
		}
		return resourceFromModel(book);
	}

	public BookResource createBook(BookResource newResource) {
		Book createdBook = bookService.create(modelFromResource(newResource));
		return resourceFromModel(createdBook);
	}

	public void put(String bookId, BookResource resource) {
		Book book = modelFromResource(resource);
		book.setBookId(bookId);
		bookService.update(book);
	}

	public void delete(String bookId) {
		bookService.delete(bookId);
	}
}
