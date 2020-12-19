package com.springguru.project1.repositories;

import com.springguru.project1.domain.Publisher;

import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    
}
