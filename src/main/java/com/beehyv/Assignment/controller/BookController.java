package com.beehyv.Assignment.controller;

import com.beehyv.Assignment.entity.Book;
import com.beehyv.Assignment.service.BookServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookServiceInterface bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{book-id}")
    public Optional<Book> getBookById(@PathVariable("book-id") Integer bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping("/books/add")
    public Book createBook(@Valid @RequestBody Book book) {
        return  bookService.createBook(book);
    }

    @PostMapping("/books")
    public Book createBookNew(@RequestBody Map<Object, Object> requestBody) {
        return bookService.createBookNew(requestBody);
    }
}
