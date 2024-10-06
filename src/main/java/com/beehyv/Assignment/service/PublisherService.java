package com.beehyv.Assignment.service;

import com.beehyv.Assignment.entity.Publisher;
import com.beehyv.Assignment.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService implements PublisherServiceInterface {

    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Optional<Publisher> getPublisherById(Integer publisherId) {
        return publisherRepository.findById(publisherId);
    }

    @Override
    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

}
