package com.springguru.project1.controllers;

import java.util.Iterator;

import com.springguru.project1.domain.Book;
import com.springguru.project1.repositories.BookRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository){this.bookRepository = bookRepository;}

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());
        Iterator<Book> books = bookRepository.findAll().iterator();
        Book book1;
        while(books.hasNext()){
            book1 = books.next();
            System.out.println(book1.getTitle());
        }
        return "list";
    }

    
}
