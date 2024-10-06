package com.beehyv.Assignment.controller;

import com.beehyv.Assignment.entity.Author;
import com.beehyv.Assignment.service.AuthorServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    private AuthorServiceInterface authorService;

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/authors/{author-id}")
    public Optional<Author> getAuthorById(@PathVariable("author-id") Integer authorId) {
        return authorService.getAuthorById(authorId);
    }

    @PostMapping("/authors")
    public Author createAuthor(@Valid @RequestBody Author author) {
        return authorService.createAuthor(author);
    }

}
