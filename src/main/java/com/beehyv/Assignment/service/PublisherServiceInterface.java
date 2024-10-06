package com.beehyv.Assignment.service;

import com.beehyv.Assignment.entity.Publisher;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface PublisherServiceInterface {

    List<Publisher> getAllPublishers();

    Optional<Publisher> getPublisherById(Integer publisherId);

    Publisher createPublisher(@Valid Publisher publisher);
}
