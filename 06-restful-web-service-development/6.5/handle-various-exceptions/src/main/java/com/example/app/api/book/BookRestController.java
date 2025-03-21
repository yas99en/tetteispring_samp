package com.example.app.api.book;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.DefaultCorsProcessor;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("books")
public class BookRestController {
    @Autowired
    BookHelper bookHelper;

    @GetMapping
    public List<BookResource> getBooks() {
        new DefaultCorsProcessor();
        return bookHelper.getBooks();
    }

    @GetMapping("{bookId}")
    public BookResource getBook(@PathVariable String bookId) {
        return bookHelper.getBook(bookId);
    }

    @PostMapping()
    public ResponseEntity<Void> createBook(
            @Validated @RequestBody BookResource newResource,
            UriComponentsBuilder uriBuilder) {
        BookResource createdResource = bookHelper.createBook(newResource);
        URI resourceUri = uriBuilder.path("/books/{bookId}")
                .buildAndExpand(createdResource.getBookId())
                .encode()
                .toUri();
        return ResponseEntity.created(resourceUri).build();
    }

    @PutMapping("{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void put(@PathVariable String bookId,
            @Validated @RequestBody BookResource resource) {
        bookHelper.put(bookId, resource);
    }

    @DeleteMapping("{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String bookId) {
        bookHelper.delete(bookId);
    }
}
