package com.beehyv.Assignment.service;

import com.beehyv.Assignment.entity.Author;
import com.beehyv.Assignment.entity.Book;
import com.beehyv.Assignment.entity.Publisher;
import com.beehyv.Assignment.repository.AuthorRepository;
import com.beehyv.Assignment.repository.BookRepository;
import com.beehyv.Assignment.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookService implements BookServiceInterface {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Integer bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book createBookNew(Map<Object, Object> requestBody) {
        String title = String.valueOf(requestBody.get("title"));
        Integer publicationYear = Integer.parseInt(String.valueOf(requestBody.get("publication_year")));
        String authorName = String.valueOf(requestBody.get("author_id"));
        String publisherName = String.valueOf(requestBody.get("publisher_id"));

        if(authorRepository.findByName(authorName).isEmpty()) {
            Author author = new Author();
            author.setName(authorName);
            authorRepository.save(author);
        }

        if(publisherRepository.findByName(publisherName).isEmpty()) {
            Publisher publisher = new Publisher();
            publisher.setName(publisherName);
            publisherRepository.save(publisher);
        }

        Book book = new Book();
        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setAuthor(authorRepository.findByName(authorName).orElse(null));
        book.setPublisher(publisherRepository.findByName(publisherName).orElse(null));

        return bookRepository.save(book);
    }
}
