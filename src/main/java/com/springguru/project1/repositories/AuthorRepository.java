package com.springguru.project1.repositories;

import com.springguru.project1.domain.Author;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>{
    
}
