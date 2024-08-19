package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // Constructor to add some dummy data
    public BookController() {
        books.add(new Book(1, "Effective Java", "Joshua Bloch", 45.0, "978-0134685991"));
        books.add(new Book(2, "Clean Code", "Robert C. Martin", 40.0, "978-0132350884"));
    }

    // Other methods (GET, POST, PUT, DELETE) will be added here
}
