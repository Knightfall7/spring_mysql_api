package com.example.spring_mysql_api.services;

import com.example.spring_mysql_api.models.Book;
import com.example.spring_mysql_api.models.Book;
import com.example.spring_mysql_api.repositories.BookRepository;
import com.example.spring_mysql_api.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class BookService {

    @Autowired

    private BookRepository repository;
    public Iterable<Book> getAllBooks() {

        return repository.findAll();
    }

//    Get one book
    public Optional<Book> getBookById(Long id){

        return repository.findById(id);
    }
    public Book createBook(Book book){
        return repository.save(book);
    }
    public boolean deleteBookById(Long id) {
        //Check if book already exists
        if (repository.existsById(id)){

            //Remove and return true if it exists.
            return true;
        }

        return false;
    }
    public boolean updateBookById(Long id, Book book){
        if (repository.existsById(id)){
            book.setId(id);
            repository.save(book);

            //Remove and return true if it exists.
            return true;
        }

        //Otherwise return false.
        return false;
    }
    public boolean seed() {
        try {
            Book[] books = {

                    new Book("Harry Potter",127),
                    new Book("Fifty Shades of Grey",450),
                    new Book("Stay away",400),
                    new Book("API",302),
                    new Book("Master mind",149),
            };

            var bookList = Arrays.stream((books)).toList();

            repository.saveAll(bookList);

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}
