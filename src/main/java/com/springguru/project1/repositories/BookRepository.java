package com.springguru.project1.repositories;

import com.springguru.project1.domain.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    
}
