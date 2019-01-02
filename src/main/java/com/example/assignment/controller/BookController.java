package com.example.assignment.controller;

import com.example.assignment.model.Book;
import com.example.assignment.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books/{id}")
    public Optional<Book> getBook(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @PostMapping("/books")
    public void saveBook(@RequestBody Book book) {
        bookRepository.save(book);
    }
}
