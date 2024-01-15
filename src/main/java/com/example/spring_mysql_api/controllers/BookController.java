package com.example.spring_mysql_api.controllers;

import com.example.spring_mysql_api.models.Book;
import com.example.spring_mysql_api.models.User;
import com.example.spring_mysql_api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/books")
public class BookController {
    BookService service;

    @GetMapping("/books")
    public Iterable<Book> getAllBooks() {
        return service.getAllBooks();
    }
}
