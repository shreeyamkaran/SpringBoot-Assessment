package com.beehyv.Assignment.service;

import com.beehyv.Assignment.entity.Book;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookServiceInterface {

    List<Book> getAllBooks();

    Optional<Book> getBookById(Integer bookId);

    Book createBook(Book book);

    Book createBookNew(Map<Object, Object> requestBody);

}
