package com.beehyv.Assignment.service;

import com.beehyv.Assignment.entity.Author;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface AuthorServiceInterface {

    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(Integer authorId);

    Author createAuthor(@Valid Author author);
}
