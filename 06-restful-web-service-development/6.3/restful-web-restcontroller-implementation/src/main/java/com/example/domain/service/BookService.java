package com.example.domain.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.domain.model.Book;
import com.example.domain.model.BookCriteria;

@Service
public class BookService {
	private final Map<String, Book> bookRepository = new ConcurrentHashMap<>();

	// 6.3.3.2. Bookリソースの取得 インメモリ実装のサービスクラスの実装例
	@PostConstruct
	public void loadDummyData(){
		Book book = new Book();
		book.setBookId("00000000-0000-0000-0000-000000000000");
		book.setName("書籍名");
		book.setPublishedDate(LocalDate.of(2024,4,20));
		bookRepository.put(book.getBookId(),book);
	}

	public Book find(String bookId) {
		Book book = bookRepository.get(bookId); // Mapから取得
		return book;
	}

	// 6.3.3.3. リソースの作成 インメモリ実装のサービスクラスの実装例
	public Book create(Book book) {
		String bookId = UUID.randomUUID().toString();
		book.setBookId(bookId);
		bookRepository.put(bookId, book); // Mapに追加
		return book;
	}

	// 6.3.3.4. リソースの更新 インメモリ実装のサービスクラスの実装例
	public Book update(Book book) {
		return bookRepository.put(book.getBookId(), book); // Mapを更新
	}

	// 6.3.3.5. リソースの削除 インメモリ実装のサービスクラスの実装例
	public Book delete(String bookId) {
		return bookRepository.remove(bookId); // Mapから削除
	}

	// 6.3.3.6. リソースの検索 インメモリ実装のサービスクラスの実装例
	public List<Book> findAllByCriteria(BookCriteria criteria) {
		return bookRepository.values().stream()
				.filter(book ->
					(criteria.getName() == null
						|| book.getName().contains(criteria.getName())) &&
					(criteria.getPublishedDate() == null
						|| book.getPublishedDate().equals(criteria.getPublishedDate())))
				.sorted((o1, o2) ->
					o1.getPublishedDate().compareTo(o2.getPublishedDate()))
				.collect(Collectors.toList());
	}
}
