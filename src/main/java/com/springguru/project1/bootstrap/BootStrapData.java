package com.springguru.project1.bootstrap;

import com.springguru.project1.domain.Address;
import com.springguru.project1.domain.Author;
import com.springguru.project1.domain.Book;
import com.springguru.project1.domain.Publisher;
import com.springguru.project1.repositories.AddressRepository;
import com.springguru.project1.repositories.AuthorRepository;
import com.springguru.project1.repositories.BookRepository;
import com.springguru.project1.repositories.PublisherRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final AddressRepository addressRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(
        AuthorRepository authorRepository, 
        BookRepository bookRepository,
        AddressRepository addressRepository,
        PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.addressRepository = addressRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception{

        Address localX = new Address();
        localX.setAddressLine("Address Line X");
        localX.setCity("City X");
        localX.setState("State X");
        localX.setZip("Zip X");

        Publisher publisher = new Publisher("MyPublisher");
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("DDD", "454545");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisher.getAddress().add(localX);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        addressRepository.save(localX);
        publisherRepository.save(publisher);


        Author rod = new Author("Rod", "Jhonson");
        Book noEJB = new Book("J2EE Development without EJB", "393939");

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of Address: " + addressRepository.count());
 
    }
    
    
}
