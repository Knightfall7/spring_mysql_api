package com.example.spring_mysql_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Title;

    private int NumberOfPages;

    public Book() {
    }

    public Book(String title, int numberOfPages) {
        Title = title;
        NumberOfPages = numberOfPages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getNumberOfPages() {
        return NumberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        NumberOfPages = numberOfPages;
    }
}
