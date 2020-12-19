package com.springguru.project1.bootstrap;

import com.springguru.project1.domain.Author;
import com.springguru.project1.domain.Book;
import com.springguru.project1.domain.Publisher;
import com.springguru.project1.repositories.AuthorRepository;
import com.springguru.project1.repositories.BookRepository;
import com.springguru.project1.repositories.PublisherRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(
        AuthorRepository authorRepository, 
        BookRepository bookRepository,
        PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        // With Relationship
        Publisher publisher = new Publisher();
        publisher.setName("MyPublisher");
        publisher.setAddressLine("Address Line X");
        publisher.setCity("City X");
        publisher.setState("State X");
        publisher.setZip("Zip X");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("DDD", "454545");

        ddd.getAuthors().add(eric);
        eric.getBooks().add(ddd);

        publisherRepository.save(publisher);
        authorRepository.save(eric);

        ddd.setPublisher(publisher);
        bookRepository.save(ddd);

        // No Relationship
        // Author rod = new Author("Rod", "Jhonson");
        // Book noEJB = new Book("J2EE Development without EJB", "393939");

        // authorRepository.save(rod);
        // bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
 
    }
    
    
}
