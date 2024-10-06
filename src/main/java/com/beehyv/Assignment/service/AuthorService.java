package com.beehyv.Assignment.service;

import com.beehyv.Assignment.entity.Author;
import com.beehyv.Assignment.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements AuthorServiceInterface {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Integer authorId) {
        return authorRepository.findById(authorId);
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

}
