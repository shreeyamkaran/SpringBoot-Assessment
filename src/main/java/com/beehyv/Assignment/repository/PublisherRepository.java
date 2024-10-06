package com.beehyv.Assignment.repository;

import com.beehyv.Assignment.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    Optional<Publisher> findByName(String publisherName);

}
