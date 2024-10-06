package com.beehyv.Assignment.controller;

import com.beehyv.Assignment.entity.Publisher;
import com.beehyv.Assignment.service.PublisherServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {

    @Autowired
    private PublisherServiceInterface publisherService;

    @GetMapping("/publishers")
    public List<Publisher> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @GetMapping("/publishers/{publisher-id}")
    public Optional<Publisher> getPublisherById(@PathVariable("publisher-id") Integer publisherId) {
        return publisherService.getPublisherById(publisherId);
    }

    @PostMapping("/publishers")
    public Publisher createPublisher(@Valid @RequestBody Publisher publisher) {
        return publisherService.createPublisher(publisher);
    }

}
