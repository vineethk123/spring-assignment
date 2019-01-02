package com.example.assignment.controller;

import com.example.assignment.model.Book;
import com.example.assignment.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable Long id) {
        Optional<Book> op = bookRepository.findById(id);
        if (op.isPresent()) {
            Book book = op.get();
            return "<p>Id: " + book.getId() + "</p><p>Author: " + book.getAuthor() +
                    "</p><p>Title: " + book.getTitle() + "</p>";
        }
        return "";
    }

    @PostMapping("/books")
    public void saveBook(@RequestBody Book book) {
        bookRepository.save(book);
    }
}
