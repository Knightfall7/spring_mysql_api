package com.example.spring_mysql_api.controllers;

import com.example.spring_mysql_api.models.Book;
import com.example.spring_mysql_api.models.User;
import com.example.spring_mysql_api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/books")
public class BookController {

    @Autowired
    BookService service;

    @GetMapping("/books")
    public Iterable<Book> getAllBooks() {
        return service.getAllBooks();
    }
    //    GET:  localhost:8080/book/5
    @GetMapping("/{id}")
    public Optional<Book> getBooksById(@PathVariable Long id){
        return service.getBookById(id);
    }
    //    DELETE: localhost:8080/books/5
    @DeleteMapping("/{id}")
    public boolean deleteBook(@PathVariable Long id) {
        return service.deleteBookById(id);
    }
    //    PUT: localhost:8080/books/5
    @PutMapping("/{id}")
    public boolean putBook(@PathVariable long id,@RequestBody Book book){
        return service.updateBookById(id,book);
    }

    //    POST: localhost:8080/books/seed
    @PostMapping("/seed")
    public boolean postSeedBooks(){
        return service.seed();
    }


}
